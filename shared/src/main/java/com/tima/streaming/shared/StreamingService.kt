package com.tima.streaming.shared

import android.app.Activity
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.AudioManager
import android.net.Uri
import android.os.Bundle
import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaBrowserCompat.MediaItem
import android.support.v4.media.MediaDescriptionCompat
import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.MediaControllerCompat
import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.media.MediaBrowserServiceCompat
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.audio.AudioAttributes
import com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector
import com.google.android.exoplayer2.ext.mediasession.TimelineQueueNavigator
import com.google.android.exoplayer2.ext.okhttp.OkHttpDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor
import com.google.android.exoplayer2.upstream.cache.SimpleCache
import com.google.android.exoplayer2.util.Log
import com.google.android.exoplayer2.util.Util
import com.tima.streaming.shared.utils.JsonSource
import com.tima.streaming.shared.utils.flag
import com.tima.streaming.shared.utils.title
import kotlinx.coroutines.*
import com.tima.streaming.shared.PackageValidator
import com.tima.streaming.shared.utils.id
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.OkHttpClient
import java.io.File

/**
 * This class provides a MediaBrowser through a service. It exposes the media library to a browsing
 * client, through the onGetRoot and onLoadChildren methods. It also creates a MediaSession and
 * exposes it through its MediaSession.Token, which allows the client to create a MediaController
 * that connects to and send control commands to the MediaSession remotely. This is useful for
 * user interfaces that need to interact with your media session, like Android Auto. You can
 * (should) also use the same service from your app's UI, which gives a seamless playback
 * experience to the user.
 *
 *
 * To implement a MediaBrowserService, you need to:
 *
 *  *  Extend [MediaBrowserServiceCompat], implementing the media browsing
 * related methods [MediaBrowserServiceCompat.onGetRoot] and
 * [MediaBrowserServiceCompat.onLoadChildren];
 *
 *  *  In onCreate, start a new [MediaSessionCompat] and notify its parent
 * with the session's token [MediaBrowserServiceCompat.setSessionToken];
 *
 *  *  Set a callback on the [MediaSessionCompat.setCallback].
 * The callback will receive all the user's actions, like play, pause, etc;
 *
 *  *  Handle all the actual music playing using any method your app prefers (for example,
 * [android.media.MediaPlayer])
 *
 *  *  Update playbackState, "now playing" metadata and queue, using MediaSession proper methods
 * [MediaSessionCompat.setPlaybackState]
 * [MediaSessionCompat.setMetadata] and
 * [MediaSessionCompat.setQueue])
 *
 *  *  Declare and export the service in AndroidManifest with an intent receiver for the action
 * android.media.browse.MediaBrowserService
 *
 * To make your app compatible with Android Auto, you also need to:
 *
 *  *  Declare a meta-data tag in AndroidManifest.xml linking to a xml resource
 * with a &lt;automotiveApp&gt; root element. For a media app, this must include
 * an &lt;uses name="media"/&gt; element as a child.
 * For example, in AndroidManifest.xml:
 * &lt;meta-data android:name="com.google.android.gms.car.application"
 * android:resource="@xml/automotive_app_desc"/&gt;
 * And in res/values/automotive_app_desc.xml:
 * &lt;automotiveApp&gt;
 * &lt;uses name="media"/&gt;
 * &lt;/automotiveApp&gt;
 *
 */
open class StreamingService : MediaBrowserServiceCompat() {

    private lateinit var session: MediaSessionCompat
    private lateinit var stateBuilder: PlaybackStateCompat.Builder
    private lateinit var mediaSource: StreamingSource

    private val serviceJob = SupervisorJob()
    private val serviceScope = CoroutineScope(Dispatchers.Main + serviceJob)

    protected lateinit var mediaController: MediaControllerCompat
    protected lateinit var mediaSessionConnector: MediaSessionConnector
    protected lateinit var packageValidator : PackageValidator

    private lateinit var becomingNoisyReceiver: BecomingNoisyReceiver
    private lateinit var notificationManager: NotificationManagerCompat
    private lateinit var notificationBuilder: NotificationBuilder

    private var isForegroundService = false


    //the api link
    private val remoteJsonSource: Uri =
        Uri.parse("https://maghradio.herokuapp.com/api/v0/")

    private val audioAttributes = AudioAttributes.Builder()
        .setContentType(C.CONTENT_TYPE_MUSIC)
        .setUsage(C.USAGE_MEDIA)
        .build()

    companion object {
        var current: Int = 0

        const val MEDIA_ROOT_ID = "/"
        const val EMPTY_MEDIA_ROOT_ID = "@empty@"
        const val NETWORK_FAILURE = "com.tima.streaming.shared.NETWORK_FAILURE"

        /** Declares that ContentStyle is supported */
        val CONTENT_STYLE_SUPPORTED = "android.media.browse.CONTENT_STYLE_SUPPORTED"

        /**
         * Bundle extra indicating the presentation hint for playable media items.
         */
        val CONTENT_STYLE_PLAYABLE_HINT = "android.media.browse.CONTENT_STYLE_PLAYABLE_HINT"

        /**
         * Bundle extra indicating the presentation hint for browsable media items.
         */
        val CONTENT_STYLE_BROWSABLE_HINT = "android.media.browse.CONTENT_STYLE_BROWSABLE_HINT"

        /**
         * Specifies the corresponding items should be presented as lists.
         */
        val CONTENT_STYLE_LIST_ITEM_HINT_VALUE = 1

        /**
         * Specifies that the corresponding items should be presented as grids.
         */
        val CONTENT_STYLE_GRID_ITEM_HINT_VALUE = 2
    }


    private val callback = object : MediaSessionCompat.Callback() {
        override fun onPlay() {
        }

        override fun onSkipToQueueItem(queueId: Long) {}

        override fun onSeekTo(position: Long) {}

        override fun onPlayFromMediaId(mediaId: String?, extras: Bundle?) {}

        override fun onPause() {}

        override fun onStop() {}

        override fun onSkipToNext() {}

        override fun onSkipToPrevious() {}

        override fun onCustomAction(action: String?, extras: Bundle?) {}

        override fun onPlayFromSearch(query: String?, extras: Bundle?) {}
    }


    /**
     *
     * Configure exooPlayer
     */
    private val exoPlayer: ExoPlayer by lazy {
        ExoPlayerFactory.newSimpleInstance(this).apply {
            setAudioAttributes(audioAttributes, true)
        }
    }

    @ExperimentalCoroutinesApi
    override fun onCreate() {

        super.onCreate()

        Log.i("onCreateService","am here ! u got me ")

        // Build a PendingIntent that can be used to launch the UI.
        val sessionActivityPendingIntent =
            packageManager?.getLaunchIntentForPackage(packageName)?.let { sessionIntent ->
                PendingIntent.getActivity(this, 0, sessionIntent, 0)
            }
        // Create a MediaSessionCompat with unique tag
        session = MediaSessionCompat(baseContext, "MyRadioService").apply {

            setSessionActivity(sessionActivityPendingIntent)
            isActive = true

            // Enable callbacks from MediaButtons and TransportControls
            /** flags **/
            setFlags(
                MediaSessionCompat.FLAG_HANDLES_QUEUE_COMMANDS
            )

            // Set an initial PlaybackState with ACTION_PLAY,
            // so media buttons can start the player
            stateBuilder = PlaybackStateCompat.Builder()
                .setActions(
                    PlaybackStateCompat.ACTION_PLAY
                            or PlaybackStateCompat.ACTION_PLAY_PAUSE
                )
            setPlaybackState(stateBuilder.build())

            // handle callbacks from a media controller
            setCallback(callback)

            //set the token for the media session
            setSessionToken(sessionToken)



            // The media library is built from a remote JSON file. We'll create the source here,
            // and then use a suspend function to perform the download off the main thread.
            mediaSource = JsonSource(context = baseContext, source = remoteJsonSource)
            serviceScope.launch {
                Log.i("source", mediaSource.toString())
                mediaSource.load()
            }

        }
        // Because ExoPlayer will manage the MediaSession, add the service as a callback for
        // state changes.
        mediaController = MediaControllerCompat(this, session).also {
            it.registerCallback(MediaControllerCallback())
        }

        notificationBuilder = NotificationBuilder(this)
        notificationManager = NotificationManagerCompat.from(this)

        becomingNoisyReceiver =
            BecomingNoisyReceiver(context = this, sessionToken = session.sessionToken)


        // ExoPlayer will manage the MediaSession for us.
        mediaSessionConnector = MediaSessionConnector(session).also { connector ->
            // Produces DataSource instances through which media data is loaded.
            val dataSourceFactory = DefaultDataSourceFactory(
                this, Util.getUserAgent(this, "agent"), null
            )
            val cache = Cache(File(this.cacheDir.absolutePath + "/exoplayer"),  1024 * 1024 * 100)
            val httpDataSourceFactory =  OkHttpDataSourceFactory(
                OkHttpClient(), Util.getUserAgent(this, "agent"),
                CacheControl.FORCE_NETWORK)

            // Create the PlaybackPreparer of the media session connector.
            val playbackPreparer = CustomPlaybackPreparer(
                mediaSource,
                exoPlayer,
                httpDataSourceFactory
            )
            Log.i("here !!", "exoplayer is finally created")

            connector.setPlayer(exoPlayer)
            connector.setPlaybackPreparer(playbackPreparer)
           // connector.setQueueEditor(session.mediaSession.)
            connector.setQueueNavigator(queueNavigatorHelper(session,mediaSource))
}

        packageValidator = PackageValidator(this, R.xml.allowed_media_browser_callers)

    }


    // to access the folder, connect to the media root
    override fun onGetRoot(
        clientPackageName: String,
        clientUid: Int,
        rootHints: Bundle?
    ): BrowserRoot {
        val isKnownCaller = packageValidator.isKnownCaller(clientPackageName, clientUid)

        /** set the default content style **/
        val extras = Bundle()
        extras.putBoolean(CONTENT_STYLE_SUPPORTED, true)
        extras.putInt(CONTENT_STYLE_BROWSABLE_HINT, CONTENT_STYLE_GRID_ITEM_HINT_VALUE)
        extras.putInt(CONTENT_STYLE_PLAYABLE_HINT, CONTENT_STYLE_LIST_ITEM_HINT_VALUE)

        /* TODO("implement this logic") */
        // (Optional) Control the level of access for the specified package name.
        // You'll need to write your own logic to do this.
        return if (isKnownCaller) {
            // Returns a root ID that clients can use with onLoadChildren() to retrieve
            // the content hierarchy.
            Log.i("root", "gonna get it")
            BrowserRoot(MEDIA_ROOT_ID, extras)
        } else {
            // Clients can connect, but this BrowserRoot is an empty hierachy
            // so onLoadChildren returns nothing. This disables the ability to browse for content.
            MediaBrowserServiceCompat.BrowserRoot(EMPTY_MEDIA_ROOT_ID, null)
        }
    }

    private val browseStation: BroweStations by lazy {
        BroweStations(applicationContext, mediaSource)
    }

    override fun onLoadChildren(parentId: String, result: Result<List<MediaItem>>) {
        /**
         * Returns (via the [result] parameter) a list of [MediaItem]s that are child
         * items of the provided [parentMediaId]. See [BrowseTree] for more details on
         * how this is build/more details about the relationships.
         **/

        // If the media source is ready, the results will be set synchronously here.
        val resultsSent = mediaSource.whenReady { successfullyInitialized ->
            if (successfullyInitialized) {
                Log.d("parentid", browseStation["/"]!!.get(0).toString()+"{$parentId}")
                val children = browseStation[parentId]?.map { item: MediaMetadataCompat ->
                    Log.d("item","${item.id} ${item.description} ${item.flag}")
                    try {
                        current = item.id.toInt()
                    } catch (e: NumberFormatException) {
                        current = 0
                    }

                    MediaItem(item.description, item.flag)
                }
                //Log.d("children","${children!!.size}")

                result.sendResult(children)
            } else {
                session.sendSessionEvent(NETWORK_FAILURE, null)
                result.sendResult(null)
            }
        }

        // If the results are not ready, the service must "detach" the results before
        // the method returns. After the source is ready, the lambda above will run,
        // and the caller will be notified that the results are ready.
        //
        // See [MediaItemFragmentViewModel.subscriptionCallback] for how this is passed to the
        // UI/displayed in the [RecyclerView].
        if (!resultsSent) {
            result.detach()
        }
    }

    /**
     * Helper class to retrieve the the Metadata necessary for the ExoPlayer MediaSession connection
     * extension to call [MediaSessionCompat.setMetadata].
     */
    private class queueNavigatorHelper(
        mediaSession: MediaSessionCompat , private val mediaSource : StreamingSource
    ) : TimelineQueueNavigator(mediaSession) {
        private val window = Timeline.Window()
        override fun getMediaDescription(player: Player, windowIndex: Int): MediaDescriptionCompat {
            Log.d("current", "${current}")
           return mediaSource.elementAt(current-1).description}
        }

    override fun onTaskRemoved(rootIntent: Intent) {
        super.onTaskRemoved(rootIntent)

        /**
         * By stopping playback, the player will transition to [Player.STATE_IDLE]. This will
         * cause a state change in the MediaSession, and (most importantly) call
         * [MediaControllerCallback.onPlaybackStateChanged]. Because the playback state will
         * be reported as [PlaybackStateCompat.STATE_NONE], the service will first remove
         * itself as a foreground service, and will then call [stopSelf].
         */
        exoPlayer.stop(true)
    }

    override fun onDestroy() {
        session.run {
            isActive = false
            release()
        }

        // Cancel coroutines when the service is going away.
        serviceJob.cancel()
    }

    private inner class MediaControllerCallback : MediaControllerCompat.Callback() {
        override fun onMetadataChanged(metadata: MediaMetadataCompat?) {
            mediaController.playbackState?.let { state ->
                serviceScope.launch {
                    updateNotification(state)
                }
            }
        }

        override fun onPlaybackStateChanged(state: PlaybackStateCompat?) {
            state?.let { state ->
                serviceScope.launch {
                    updateNotification(state)
                }
            }
        }
    }

        private suspend fun updateNotification(state: PlaybackStateCompat) {
            val updatedState = state.state

            // Skip building a notification when state is "none" and metadata is null.
            val notification = if (mediaController.metadata != null
                && updatedState != PlaybackStateCompat.STATE_NONE) {
                notificationBuilder.buildNotification(session.sessionToken)
            } else {
                null
            }

            when (updatedState) {
                PlaybackStateCompat.STATE_BUFFERING,
                PlaybackStateCompat.STATE_PLAYING -> {
                    becomingNoisyReceiver.register()

                    /**
                     * This may look strange, but the documentation for [Service.startForeground]
                     * notes that "calling this method does *not* put the service in the started
                     * state itself, even though the name sounds like it."
                     */
                    if (notification != null) {
                        notificationManager.notify(NOW_PLAYING_NOTIFICATION, notification)

                        if (!isForegroundService) {
                            ContextCompat.startForegroundService(
                                applicationContext,
                                Intent(applicationContext, this@StreamingService.javaClass)
                            )
                            startForeground(NOW_PLAYING_NOTIFICATION, notification)
                            isForegroundService = true
                        }
                    }
                }
                else -> {
                    becomingNoisyReceiver.unregister()

                    if (isForegroundService) {
                        stopForeground(false)
                        isForegroundService = false

                        // If playback has ended, also stop the service.
                        if (updatedState == PlaybackStateCompat.STATE_NONE) {
                            stopSelf()
                        }

                        if (notification != null) {
                            notificationManager.notify(NOW_PLAYING_NOTIFICATION, notification)
                        } else {
                            stopForeground(true)
                        }
                    }
                }
            }
        }

/**
 * Helper class for listening for when headphones are unplugged (or the audio
 * will otherwise cause playback to become "noisy").
 */
private class BecomingNoisyReceiver(private val context: Context, sessionToken: MediaSessionCompat.Token) : BroadcastReceiver() {

    private val noisyIntentFilter = IntentFilter(AudioManager.ACTION_AUDIO_BECOMING_NOISY)
    private val controller = MediaControllerCompat(context, sessionToken)

    private var registered = false

    fun register() {
        if (!registered) {
            context.registerReceiver(this, noisyIntentFilter)
            registered = true
        }
    }

    fun unregister() {
        if (registered) {
            context.unregisterReceiver(this)
            registered = false
        }
    }

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == AudioManager.ACTION_AUDIO_BECOMING_NOISY) {
            controller.transportControls.pause()
        }
    }
}

}



package com.tima.streaming.shared;

import java.lang.System;

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
 * *  Extend [MediaBrowserServiceCompat], implementing the media browsing
 * related methods [MediaBrowserServiceCompat.onGetRoot] and
 * [MediaBrowserServiceCompat.onLoadChildren];
 *
 * *  In onCreate, start a new [MediaSessionCompat] and notify its parent
 * with the session's token [MediaBrowserServiceCompat.setSessionToken];
 *
 * *  Set a callback on the [MediaSessionCompat.setCallback].
 * The callback will receive all the user's actions, like play, pause, etc;
 *
 * *  Handle all the actual music playing using any method your app prefers (for example,
 * [android.media.MediaPlayer])
 *
 * *  Update playbackState, "now playing" metadata and queue, using MediaSession proper methods
 * [MediaSessionCompat.setPlaybackState]
 * [MediaSessionCompat.setMetadata] and
 * [MediaSessionCompat.setQueue])
 *
 * *  Declare and export the service in AndroidManifest with an intent receiver for the action
 * android.media.browse.MediaBrowserService
 *
 * To make your app compatible with Android Auto, you also need to:
 *
 * *  Declare a meta-data tag in AndroidManifest.xml linking to a xml resource
 * with a &lt;automotiveApp&gt; root element. For a media app, this must include
 * an &lt;uses name="media"/&gt; element as a child.
 * For example, in AndroidManifest.xml:
 * &lt;meta-data android:name="com.google.android.gms.car.application"
 * android:resource="@xml/automotive_app_desc"/&gt;
 * And in res/values/automotive_app_desc.xml:
 * &lt;automotiveApp&gt;
 * &lt;uses name="media"/&gt;
 * &lt;/automotiveApp&gt;
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 R2\u00020\u0001:\u0004QRSTB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u00109\u001a\u00020:H\u0017J\b\u0010;\u001a\u00020:H\u0016J\"\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J$\u0010D\u001a\u00020:2\u0006\u0010E\u001a\u00020?2\u0012\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0H0GH\u0016J\u0010\u0010J\u001a\u00020:2\u0006\u0010K\u001a\u00020LH\u0016J\u0019\u0010M\u001a\u00020:2\u0006\u0010N\u001a\u00020OH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010PR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0084.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0084.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020(X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020*X\u0084.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082.\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006U"}, d2 = {"Lcom/tima/streaming/shared/StreamingService;", "Landroidx/media/MediaBrowserServiceCompat;", "()V", "audioAttributes", "Lcom/google/android/exoplayer2/audio/AudioAttributes;", "kotlin.jvm.PlatformType", "becomingNoisyReceiver", "Lcom/tima/streaming/shared/StreamingService$BecomingNoisyReceiver;", "browseStation", "Lcom/tima/streaming/shared/BroweStations;", "getBrowseStation", "()Lcom/tima/streaming/shared/BroweStations;", "browseStation$delegate", "Lkotlin/Lazy;", "callback", "Landroid/support/v4/media/session/MediaSessionCompat$Callback;", "exoPlayer", "Lcom/google/android/exoplayer2/ExoPlayer;", "getExoPlayer", "()Lcom/google/android/exoplayer2/ExoPlayer;", "exoPlayer$delegate", "isForegroundService", "", "mediaController", "Landroid/support/v4/media/session/MediaControllerCompat;", "getMediaController", "()Landroid/support/v4/media/session/MediaControllerCompat;", "setMediaController", "(Landroid/support/v4/media/session/MediaControllerCompat;)V", "mediaSessionConnector", "Lcom/google/android/exoplayer2/ext/mediasession/MediaSessionConnector;", "getMediaSessionConnector", "()Lcom/google/android/exoplayer2/ext/mediasession/MediaSessionConnector;", "setMediaSessionConnector", "(Lcom/google/android/exoplayer2/ext/mediasession/MediaSessionConnector;)V", "mediaSource", "Lcom/tima/streaming/shared/StreamingSource;", "notificationBuilder", "Lcom/tima/streaming/shared/NotificationBuilder;", "notificationManager", "Landroidx/core/app/NotificationManagerCompat;", "packageValidator", "Lcom/tima/streaming/shared/PackageValidator;", "getPackageValidator", "()Lcom/tima/streaming/shared/PackageValidator;", "setPackageValidator", "(Lcom/tima/streaming/shared/PackageValidator;)V", "remoteJsonSource", "Landroid/net/Uri;", "serviceJob", "Lkotlinx/coroutines/Job;", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "session", "Landroid/support/v4/media/session/MediaSessionCompat;", "stateBuilder", "Landroid/support/v4/media/session/PlaybackStateCompat$Builder;", "onCreate", "", "onDestroy", "onGetRoot", "Landroidx/media/MediaBrowserServiceCompat$BrowserRoot;", "clientPackageName", "", "clientUid", "", "rootHints", "Landroid/os/Bundle;", "onLoadChildren", "parentId", "result", "Landroidx/media/MediaBrowserServiceCompat$Result;", "", "Landroid/support/v4/media/MediaBrowserCompat$MediaItem;", "onTaskRemoved", "rootIntent", "Landroid/content/Intent;", "updateNotification", "state", "Landroid/support/v4/media/session/PlaybackStateCompat;", "(Landroid/support/v4/media/session/PlaybackStateCompat;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "BecomingNoisyReceiver", "Companion", "MediaControllerCallback", "queueNavigatorHelper", "shared_debug"})
public class StreamingService extends androidx.media.MediaBrowserServiceCompat {
    private android.support.v4.media.session.MediaSessionCompat session;
    private android.support.v4.media.session.PlaybackStateCompat.Builder stateBuilder;
    private com.tima.streaming.shared.StreamingSource mediaSource;
    private final kotlinx.coroutines.Job serviceJob = null;
    private final kotlinx.coroutines.CoroutineScope serviceScope = null;
    @org.jetbrains.annotations.NotNull()
    protected android.support.v4.media.session.MediaControllerCompat mediaController;
    @org.jetbrains.annotations.NotNull()
    protected com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector mediaSessionConnector;
    @org.jetbrains.annotations.NotNull()
    protected com.tima.streaming.shared.PackageValidator packageValidator;
    private com.tima.streaming.shared.StreamingService.BecomingNoisyReceiver becomingNoisyReceiver;
    private androidx.core.app.NotificationManagerCompat notificationManager;
    private com.tima.streaming.shared.NotificationBuilder notificationBuilder;
    private boolean isForegroundService;
    private final android.net.Uri remoteJsonSource = null;
    private final com.google.android.exoplayer2.audio.AudioAttributes audioAttributes = null;
    private final android.support.v4.media.session.MediaSessionCompat.Callback callback = null;
    
    /**
     * Configure exooPlayer
     */
    private final kotlin.Lazy exoPlayer$delegate = null;
    private final kotlin.Lazy browseStation$delegate = null;
    private static int current;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MEDIA_ROOT_ID = "/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EMPTY_MEDIA_ROOT_ID = "@empty@";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NETWORK_FAILURE = "com.tima.streaming.shared.NETWORK_FAILURE";
    
    /**
     * Declares that ContentStyle is supported
     */
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String CONTENT_STYLE_SUPPORTED = "android.media.browse.CONTENT_STYLE_SUPPORTED";
    
    /**
     * Bundle extra indicating the presentation hint for playable media items.
     */
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String CONTENT_STYLE_PLAYABLE_HINT = "android.media.browse.CONTENT_STYLE_PLAYABLE_HINT";
    
    /**
     * Bundle extra indicating the presentation hint for browsable media items.
     */
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String CONTENT_STYLE_BROWSABLE_HINT = "android.media.browse.CONTENT_STYLE_BROWSABLE_HINT";
    
    /**
     * Specifies the corresponding items should be presented as lists.
     */
    private static final int CONTENT_STYLE_LIST_ITEM_HINT_VALUE = 1;
    
    /**
     * Specifies that the corresponding items should be presented as grids.
     */
    private static final int CONTENT_STYLE_GRID_ITEM_HINT_VALUE = 2;
    public static final com.tima.streaming.shared.StreamingService.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    protected final android.support.v4.media.session.MediaControllerCompat getMediaController() {
        return null;
    }
    
    protected final void setMediaController(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.session.MediaControllerCompat p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector getMediaSessionConnector() {
        return null;
    }
    
    protected final void setMediaSessionConnector(@org.jetbrains.annotations.NotNull()
    com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.tima.streaming.shared.PackageValidator getPackageValidator() {
        return null;
    }
    
    protected final void setPackageValidator(@org.jetbrains.annotations.NotNull()
    com.tima.streaming.shared.PackageValidator p0) {
    }
    
    /**
     * Configure exooPlayer
     */
    private final com.google.android.exoplayer2.ExoPlayer getExoPlayer() {
        return null;
    }
    
    @kotlinx.coroutines.ExperimentalCoroutinesApi()
    @java.lang.Override()
    public void onCreate() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.media.MediaBrowserServiceCompat.BrowserRoot onGetRoot(@org.jetbrains.annotations.NotNull()
    java.lang.String clientPackageName, int clientUid, @org.jetbrains.annotations.Nullable()
    android.os.Bundle rootHints) {
        return null;
    }
    
    private final com.tima.streaming.shared.BroweStations getBrowseStation() {
        return null;
    }
    
    @java.lang.Override()
    public void onLoadChildren(@org.jetbrains.annotations.NotNull()
    java.lang.String parentId, @org.jetbrains.annotations.NotNull()
    androidx.media.MediaBrowserServiceCompat.Result<java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem>> result) {
    }
    
    @java.lang.Override()
    public void onTaskRemoved(@org.jetbrains.annotations.NotNull()
    android.content.Intent rootIntent) {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    public StreamingService() {
        super();
    }
    
    /**
     * Helper class to retrieve the the Metadata necessary for the ExoPlayer MediaSession connection
     * extension to call [MediaSessionCompat.setMetadata].
     */
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tima/streaming/shared/StreamingService$queueNavigatorHelper;", "Lcom/google/android/exoplayer2/ext/mediasession/TimelineQueueNavigator;", "mediaSession", "Landroid/support/v4/media/session/MediaSessionCompat;", "mediaSource", "Lcom/tima/streaming/shared/StreamingSource;", "(Landroid/support/v4/media/session/MediaSessionCompat;Lcom/tima/streaming/shared/StreamingSource;)V", "window", "Lcom/google/android/exoplayer2/Timeline$Window;", "getMediaDescription", "Landroid/support/v4/media/MediaDescriptionCompat;", "player", "Lcom/google/android/exoplayer2/Player;", "windowIndex", "", "shared_debug"})
    static final class queueNavigatorHelper extends com.google.android.exoplayer2.ext.mediasession.TimelineQueueNavigator {
        private final com.google.android.exoplayer2.Timeline.Window window = null;
        private final com.tima.streaming.shared.StreamingSource mediaSource = null;
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public android.support.v4.media.MediaDescriptionCompat getMediaDescription(@org.jetbrains.annotations.NotNull()
        com.google.android.exoplayer2.Player player, int windowIndex) {
            return null;
        }
        
        public queueNavigatorHelper(@org.jetbrains.annotations.NotNull()
        android.support.v4.media.session.MediaSessionCompat mediaSession, @org.jetbrains.annotations.NotNull()
        com.tima.streaming.shared.StreamingSource mediaSource) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tima/streaming/shared/StreamingService$MediaControllerCallback;", "Landroid/support/v4/media/session/MediaControllerCompat$Callback;", "(Lcom/tima/streaming/shared/StreamingService;)V", "onMetadataChanged", "", "metadata", "Landroid/support/v4/media/MediaMetadataCompat;", "onPlaybackStateChanged", "state", "Landroid/support/v4/media/session/PlaybackStateCompat;", "shared_debug"})
    final class MediaControllerCallback extends android.support.v4.media.session.MediaControllerCompat.Callback {
        
        @java.lang.Override()
        public void onMetadataChanged(@org.jetbrains.annotations.Nullable()
        android.support.v4.media.MediaMetadataCompat metadata) {
        }
        
        @java.lang.Override()
        public void onPlaybackStateChanged(@org.jetbrains.annotations.Nullable()
        android.support.v4.media.session.PlaybackStateCompat state) {
        }
        
        public MediaControllerCallback() {
            super();
        }
    }
    
    /**
     * Helper class for listening for when headphones are unplugged (or the audio
     * will otherwise cause playback to become "noisy").
     */
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tima/streaming/shared/StreamingService$BecomingNoisyReceiver;", "Landroid/content/BroadcastReceiver;", "context", "Landroid/content/Context;", "sessionToken", "Landroid/support/v4/media/session/MediaSessionCompat$Token;", "(Landroid/content/Context;Landroid/support/v4/media/session/MediaSessionCompat$Token;)V", "controller", "Landroid/support/v4/media/session/MediaControllerCompat;", "noisyIntentFilter", "Landroid/content/IntentFilter;", "registered", "", "onReceive", "", "intent", "Landroid/content/Intent;", "register", "unregister", "shared_debug"})
    static final class BecomingNoisyReceiver extends android.content.BroadcastReceiver {
        private final android.content.IntentFilter noisyIntentFilter = null;
        private final android.support.v4.media.session.MediaControllerCompat controller = null;
        private boolean registered;
        private final android.content.Context context = null;
        
        public final void register() {
        }
        
        public final void unregister() {
        }
        
        @java.lang.Override()
        public void onReceive(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        android.content.Intent intent) {
        }
        
        public BecomingNoisyReceiver(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        android.support.v4.media.session.MediaSessionCompat.Token sessionToken) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/tima/streaming/shared/StreamingService$Companion;", "", "()V", "CONTENT_STYLE_BROWSABLE_HINT", "", "getCONTENT_STYLE_BROWSABLE_HINT", "()Ljava/lang/String;", "CONTENT_STYLE_GRID_ITEM_HINT_VALUE", "", "getCONTENT_STYLE_GRID_ITEM_HINT_VALUE", "()I", "CONTENT_STYLE_LIST_ITEM_HINT_VALUE", "getCONTENT_STYLE_LIST_ITEM_HINT_VALUE", "CONTENT_STYLE_PLAYABLE_HINT", "getCONTENT_STYLE_PLAYABLE_HINT", "CONTENT_STYLE_SUPPORTED", "getCONTENT_STYLE_SUPPORTED", "EMPTY_MEDIA_ROOT_ID", "MEDIA_ROOT_ID", "NETWORK_FAILURE", "current", "getCurrent", "setCurrent", "(I)V", "shared_debug"})
    public static final class Companion {
        
        public final int getCurrent() {
            return 0;
        }
        
        public final void setCurrent(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCONTENT_STYLE_SUPPORTED() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCONTENT_STYLE_PLAYABLE_HINT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCONTENT_STYLE_BROWSABLE_HINT() {
            return null;
        }
        
        public final int getCONTENT_STYLE_LIST_ITEM_HINT_VALUE() {
            return 0;
        }
        
        public final int getCONTENT_STYLE_GRID_ITEM_HINT_VALUE() {
            return 0;
        }
        
        private Companion() {
            super();
        }
    }
}
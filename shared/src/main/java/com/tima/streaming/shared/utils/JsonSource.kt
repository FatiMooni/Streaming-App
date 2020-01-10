package com.tima.streaming.shared.utils

import android.content.Context
import android.net.Uri
import android.support.v4.media.MediaMetadataCompat
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.google.gson.Gson
import com.tima.streaming.shared.*
import com.tima.streaming.shared.models.JsonMusic
import com.tima.streaming.shared.models.JsonPlayList
import com.tima.streaming.shared.models.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL

/**
 * Source of [MediaMetadataCompat] objects created from a basic JSON stream.
 **/

class JsonSource(context: Context, private val source: Uri) : AbstractStreamingSource() {

    var playList: List<MediaMetadataCompat> = emptyList()
    private val glide: RequestManager

    companion object {
        private const val NOTIFICATION_LARGE_ICON_SIZE = 144 // px

        private val glideOptions = RequestOptions()
            .fallback(R.drawable.music)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
    }

    //initialization
    init {
        state = STATE_INITIALIZING
        glide = StreamingAppGlide.with(context)
    }

    //for searching , browsing ...etc
    override fun iterator(): Iterator<MediaMetadataCompat> = playList.iterator()

    //used to uplaod the playlist from the remote JSON file into a list
    //so it can be easier to use it

    override suspend fun load() {
        updateCatalog(source)?.let { updatedCatalog ->
            playList = updatedCatalog
            state = STATE_INITIALIZED
        } ?: run {
            //in case of error ( network , format , ... )
            playList = emptyList()
            state = STATE_ERROR
        }
    }

    /**
     * Function to connect to a remote URI and download
     * the JSON file that corresponds to
     * [MediaMetadataCompat] objects.
     **/
    private suspend fun updateCatalog(catalogUri: Uri): List<MediaMetadataCompat>? {
        return withContext(Dispatchers.IO) {

            //first step
            val musicCat = try {
                downloadJson(catalogUri)
            } catch (ioException: IOException) {
                return@withContext null
            }

            //testing
            Log.i("music catalog", musicCat.playlists[0].title)

            //for cover / background images => upload with glide
            musicCat.playlists.map { song: JsonMusic ->
                // Block on downloading artwork.
                val artFile = glide.applyDefaultRequestOptions(glideOptions)
                    .downloadOnly()
                    .load(song.background_url)
                    .submit(NOTIFICATION_LARGE_ICON_SIZE, NOTIFICATION_LARGE_ICON_SIZE)
                    .get()

                // Expose file via Local URI
                val artUri = artFile.asAlbumArtContentUri()

                MediaMetadataCompat.Builder()
                    .from(song)
                    .apply {
                        displayIconUri = artUri.toString() // Used by ExoPlayer and Notification
                        stationPictureUri = artUri.toString()
                    }
                    .build()
            }.toList()
        }
    }


    /**
     * Attempts to download a playlist / stations list from a given Uri.
     * @param sourceUri URI to attempt to download the whole playlist.
     * @return The playlist downloaded, or an empty list if an error occurred.
     **/

    @Throws(IOException::class)
    private fun downloadJson(sourceUri: Uri): JsonPlayList {
        val apiConn = URL(sourceUri.toString())
        val reader = BufferedReader(InputStreamReader(apiConn.openStream()))
        return Gson().fromJson<JsonPlayList>(reader, JsonPlayList::class.java)
    }
}




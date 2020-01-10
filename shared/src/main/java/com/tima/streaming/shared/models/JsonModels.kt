package com.tima.streaming.shared.models

import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaDescriptionCompat
import android.support.v4.media.MediaMetadataCompat
import com.tima.streaming.shared.utils.*
import java.util.concurrent.TimeUnit
import android.R.attr.description
import android.content.Context
import android.provider.MediaStore.Images.Media.getBitmap
import android.graphics.Bitmap
import android.os.Bundle



/**
 * Extension method for [MediaMetadataCompat.Builder] to set the fields from
 * our JSON constructed object [JsonMusic] .
 */
fun MediaMetadataCompat.Builder.from(jsonMusic: JsonMusic): MediaMetadataCompat.Builder {

    id = jsonMusic.id
    title = jsonMusic.now_playing!!.song
    artist = jsonMusic.now_playing!!.artist
    station = jsonMusic.title
    genre = jsonMusic.title
    mediaUri = jsonMusic.url
    stationPictureUri = jsonMusic.background_url
    flag = MediaBrowserCompat.MediaItem.FLAG_PLAYABLE

    // To make things easier for *displaying* these, set the display properties as well.
    displayTitle = jsonMusic.now_playing!!.song
    displaySubtitle = jsonMusic.now_playing!!.artist
    displayDescription = jsonMusic.title
    displayIconUri = jsonMusic.now_playing!!.cover

    // Add downloadStatus to force the creation of an "extras" bundle in the resulting
    // MediaMetadataCompat object. This is needed to send accurate metadata to the
    // media session during updates.
    downloadStatus = MediaDescriptionCompat.STATUS_NOT_DOWNLOADED
    // Allow it to be used in the typical builder style.
    return this
}

fun getMediaDescription(context: Context, sample: JsonMusic): MediaDescriptionCompat {
    val extras = Bundle()
    return MediaDescriptionCompat.Builder()
        .setMediaId(sample.id)
        .setTitle(sample.now_playing!!.song)
        .setDescription(sample.title)
        .setExtras(extras)
        .build()
}
/**
 * Wrapper object for our JSON in order to be processed easily by GSON.
 * this class has two main parts [default_playlist] & [playlists] according to the API response
 */
class JsonPlayList {
    var default_playlist: JsonMusic? = null
    var playlists : List<JsonMusic> = ArrayList()
}

/**
 * An individual piece of music i.e. current streaming on station [title] included in the JSON playlist.
 * The format of the data class is similar to the one from the server (API)
 **/
@Suppress("unused")
class JsonMusic {
    var id: String = ""
    var url : String = ""
    var title: String = ""
    var subtitle: String = ""
    var background_url: String = ""
    var now_playing : nowPlaying? = null
}


class nowPlaying {
    var song : String = ""
    var artist: String = ""
    var cover : String = ""
}
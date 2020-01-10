package com.tima.streaming.shared

import com.tima.streaming.shared.utils.*



import android.content.Context
import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaBrowserCompat.MediaItem
import android.support.v4.media.MediaMetadataCompat
import android.util.Log


/**
 * Represents a tree of media that's used by [MusicService.onLoadChildren].
 *
 * [BrowseTree] maps a media id (see: [MediaMetadataCompat.METADATA_KEY_MEDIA_ID]) to one (or
 * more) [MediaMetadataCompat] objects, which are children of that media id.
 *
 * For example, given the following conceptual tree:
 * root
 *  +-- Albums
 *  |    +-- Album_A
 *  |    |    +-- Song_1
 *  |    |    +-- Song_2
 *  ...
 *  +-- Artists
 *  ...
 *
 *  Requesting `browseTree["root"]` would return a list that included "Albums", "Artists", and
 *  any other direct children. Taking the media ID of "Albums" ("Albums" in this example),
 *  `browseTree["Albums"]` would return a single item list "Album_A", and, finally,
 *  `browseTree["Album_A"]` would return "Song_1" and "Song_2". Since those are leaf nodes,
 *  requesting `browseTree["Song_1"]` would return null (there aren't any children of it).
 */
class BroweStations (context: Context, musicSource: StreamingSource) {

    private val mediaIdToChildren = mutableMapOf<String, MutableList<MediaMetadataCompat>>()

    //constant strings to use as tags
    companion object {
        const val RADIO_STREAMING_BROWSABLE_ROOT = "/"
        const val RADIO_STREAMING_EMPTY_ROOT = "@empty@"
        const val RADIO_STREAMING_RECOMMENDED_ROOT = "__RECOMMENDED__"
        const val RADIO_STREAMING_STATIONS_ROOT = "__STATIONS__"
        const val MEDIA_SEARCH_SUPPORTED = "android.media.browse.SEARCH_SUPPORTED"
        const val RESOURCE_ROOT_URI = "android.resource://com.tima.android.streaming/drawable/"
    }
    /**
     * Whether to allow clients which are unknown (non-whitelisted) to use search on this
     * [BrowseTree].
     */
    val searchableByUnknownCaller = true

    /**
     * there's a single root node (identified by the constant [RADIO_STREAMING_BROWSABLE_ROO]).
     * The root's children are each station included in the
     * [MusicSource], and each station has one child == one current song i.e. live streaming.
     * (See [BrowseTree.buildAlbumRoot] for more details.)
     *
     * TODO: Expand to allow more browsing types.
     */
    init {
        val rootList = mediaIdToChildren[RADIO_STREAMING_BROWSABLE_ROOT] ?: mutableListOf()

        ///Log.i("root list" , "initiated $musicSource")

        val recommendedMetadata = MediaMetadataCompat.Builder().apply {
            id = RADIO_STREAMING_RECOMMENDED_ROOT
            title = "Recommended"
            //stationPictureUri = RESOURCE_ROOT_URI +
                  //  context.resources.getResourceEntryName(R.drawable.music)
            flag = MediaItem.FLAG_BROWSABLE
        }.build()

        val stationsMetadata = MediaMetadataCompat.Builder().apply {
            id = RADIO_STREAMING_STATIONS_ROOT
            title = "Stations"
           // stationPictureUri = RESOURCE_ROOT_URI +
                 //   context.resources.getResourceEntryName(R.drawable.music)
            flag = MediaItem.FLAG_BROWSABLE
        }.build()

        rootList += recommendedMetadata
        rootList += stationsMetadata
        mediaIdToChildren[RADIO_STREAMING_BROWSABLE_ROOT] = rootList
        Log.i("rootlist", "${rootList[0].description}")

        musicSource.forEach { mediaItem: MediaMetadataCompat ->
            Log.d("media", "${mediaItem.title} ${mediaItem.mediaUri}")

            val stationMediaId = mediaItem.station.urlEncoded
            val stationCurrentSong = mediaIdToChildren[stationMediaId] ?: buildStationRoot(mediaItem)
            stationCurrentSong += mediaItem

            // Add the first station to the 'Recommended' category
            if (mediaItem.id == "1"){
                val recommendedChildren = mediaIdToChildren[RADIO_STREAMING_RECOMMENDED_ROOT]
                    ?: mutableListOf()
                recommendedChildren += mediaItem
                mediaIdToChildren[RADIO_STREAMING_RECOMMENDED_ROOT] = recommendedChildren
            }
        }
    }

    /**
     * Provide access to the list of children with the `get` operator.
     * i.e.: `browseTree\[UAMP_BROWSABLE_ROOT\]`
     */
    operator fun get(mediaId: String) = mediaIdToChildren[mediaId]

    /**
     * Builds a node, under the root, that represents an album, given
     * a [MediaMetadataCompat] object that's one of the songs on that album,
     * marking the item as [MediaItem.FLAG_BROWSABLE], since it will have child
     * node(s) AKA at least 1 song.
     */
    private fun buildStationRoot(mediaItem: MediaMetadataCompat) : MutableList<MediaMetadataCompat> {
        val albumMetadata = MediaMetadataCompat.Builder().apply {
            id = mediaItem.station.urlEncoded
            title = mediaItem.station
            artist = mediaItem.artist
            mediaUri = mediaItem.mediaUri.toString()
            stationPicture = mediaItem.stationPicture
            stationPictureUri = mediaItem.stationPictureUri.toString()
            flag = MediaItem.FLAG_BROWSABLE
        }.build()

        // Adds this album to the 'Albums' category.
        val rootList = mediaIdToChildren[RADIO_STREAMING_STATIONS_ROOT] ?: mutableListOf()
        rootList += albumMetadata
        mediaIdToChildren[RADIO_STREAMING_STATIONS_ROOT] = rootList

        // Insert the album's root with an empty list for its children, and return the list.
        return mutableListOf<MediaMetadataCompat>().also {
            mediaIdToChildren[albumMetadata.id] = it
        }
    }
}



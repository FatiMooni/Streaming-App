package com.tima.streaming.shared.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000P\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u001a\u001a\u0010_\u001a\n a*\u0004\u0018\u00010`0`*\u00020\u00042\u0006\u0010b\u001a\u00020c\u001a\u0018\u0010_\u001a\u00020d*\b\u0012\u0004\u0012\u00020\u00040e2\u0006\u0010b\u001a\u00020c\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u0001*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0006\".\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u00018\u00c7\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\u000b\"\u0004\b\f\u0010\r\"\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u0001*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006\"\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0006\"\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u0001*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006\"\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u0001*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0006\"\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u0001*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0006\".\u0010\u0016\u001a\u0004\u0018\u00010\u0001*\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u00018\u00c7\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\r\"\u0016\u0010\u0019\u001a\u00020\u001a*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0016\u0010\u001d\u001a\u00020\u001e*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \".\u0010\u001d\u001a\u0004\u0018\u00010\u0001*\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u00018\u00c7\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b!\u0010\r\"\u0018\u0010\"\u001a\u0004\u0018\u00010\u0001*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0006\".\u0010\"\u001a\u0004\u0018\u00010\u0001*\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u00018\u00c7\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b#\u0010\u000b\"\u0004\b$\u0010\r\"\u0018\u0010%\u001a\u0004\u0018\u00010\u0001*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u0006\".\u0010%\u001a\u0004\u0018\u00010\u0001*\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u00018\u00c7\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b&\u0010\u000b\"\u0004\b\'\u0010\r\"\u0016\u0010(\u001a\u00020)*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b*\u0010+\"*\u0010(\u001a\u00020)*\u00020\n2\u0006\u0010\t\u001a\u00020)8\u00c7\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b*\u0010,\"\u0004\b-\u0010.\"\u0016\u0010/\u001a\u00020)*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b0\u0010+\"*\u0010/\u001a\u00020)*\u00020\n2\u0006\u0010\t\u001a\u00020)8\u00c7\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.\"\u001c\u00102\u001a\u000203*\u00020\u00048\u00c6\u0002\u00a2\u0006\f\u0012\u0004\b4\u00105\u001a\u0004\b6\u00107\"0\u00102\u001a\u000203*\u00020\n2\u0006\u0010\t\u001a\u0002038\u00c7\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\u0012\u0012\u0004\b4\u00108\u001a\u0004\b6\u00109\"\u0004\b:\u0010;\"\u0018\u0010<\u001a\u0004\u0018\u00010\u0001*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b=\u0010\u0006\".\u0010<\u001a\u0004\u0018\u00010\u0001*\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u00018\u00c7\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b=\u0010\u000b\"\u0004\b>\u0010\r\"\u0016\u0010?\u001a\u00020\u0001*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b@\u0010\u0006\"*\u0010?\u001a\u00020\u0001*\u00020\n2\u0006\u0010\t\u001a\u00020\u00018\u00c7\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b@\u0010\u000b\"\u0004\bA\u0010\r\"\u0016\u0010B\u001a\u00020\u001e*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\bC\u0010 \".\u0010B\u001a\u0004\u0018\u00010\u0001*\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u00018\u00c7\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\bC\u0010\u000b\"\u0004\bD\u0010\r\"\u0016\u0010E\u001a\u00020\u001a*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\bF\u0010\u001c\"\u0016\u0010G\u001a\u00020\u001e*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\bH\u0010 \"\u0016\u0010I\u001a\u00020)*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\bJ\u0010+\"\u0018\u0010K\u001a\u0004\u0018\u00010\u0001*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\bL\u0010\u0006\".\u0010K\u001a\u0004\u0018\u00010\u0001*\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u00018\u00c7\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\bL\u0010\u000b\"\u0004\bM\u0010\r\"\u0018\u0010N\u001a\u0004\u0018\u00010\u001a*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\bO\u0010\u001c\".\u0010N\u001a\u0004\u0018\u00010\u001a*\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u001a8\u00c7\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010R\"\u0016\u0010S\u001a\u00020\u001e*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\bT\u0010 \".\u0010S\u001a\u0004\u0018\u00010\u0001*\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u00018\u00c7\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\bT\u0010\u000b\"\u0004\bU\u0010\r\"\u0018\u0010V\u001a\u0004\u0018\u00010\u0001*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\bW\u0010\u0006\".\u0010V\u001a\u0004\u0018\u00010\u0001*\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u00018\u00c7\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\bW\u0010\u000b\"\u0004\bX\u0010\r\"\u0016\u0010Y\u001a\u00020)*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\bZ\u0010+\"\u0018\u0010[\u001a\u0004\u0018\u00010\u0001*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\\\u0010\u0006\"\u0018\u0010]\u001a\u0004\u0018\u00010\u0001*\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b^\u0010\u0006\u00a8\u0006f"}, d2 = {"METADATA_KEY_UAMP_FLAGS", "", "NO_GET", "albumArtist", "Landroid/support/v4/media/MediaMetadataCompat;", "getAlbumArtist", "(Landroid/support/v4/media/MediaMetadataCompat;)Ljava/lang/String;", "artist", "getArtist", "value", "Landroid/support/v4/media/MediaMetadataCompat$Builder;", "(Landroid/support/v4/media/MediaMetadataCompat$Builder;)Ljava/lang/String;", "setArtist", "(Landroid/support/v4/media/MediaMetadataCompat$Builder;Ljava/lang/String;)V", "author", "getAuthor", "compilation", "getCompilation", "composer", "getComposer", "date", "getDate", "displayDescription", "getDisplayDescription", "setDisplayDescription", "displayIcon", "Landroid/graphics/Bitmap;", "getDisplayIcon", "(Landroid/support/v4/media/MediaMetadataCompat;)Landroid/graphics/Bitmap;", "displayIconUri", "Landroid/net/Uri;", "getDisplayIconUri", "(Landroid/support/v4/media/MediaMetadataCompat;)Landroid/net/Uri;", "setDisplayIconUri", "displaySubtitle", "getDisplaySubtitle", "setDisplaySubtitle", "displayTitle", "getDisplayTitle", "setDisplayTitle", "downloadStatus", "", "getDownloadStatus", "(Landroid/support/v4/media/MediaMetadataCompat;)J", "(Landroid/support/v4/media/MediaMetadataCompat$Builder;)J", "setDownloadStatus", "(Landroid/support/v4/media/MediaMetadataCompat$Builder;J)V", "duration", "getDuration", "setDuration", "flag", "", "flag$annotations", "(Landroid/support/v4/media/MediaMetadataCompat;)V", "getFlag", "(Landroid/support/v4/media/MediaMetadataCompat;)I", "(Landroid/support/v4/media/MediaMetadataCompat$Builder;)V", "(Landroid/support/v4/media/MediaMetadataCompat$Builder;)I", "setFlag", "(Landroid/support/v4/media/MediaMetadataCompat$Builder;I)V", "genre", "getGenre", "setGenre", "id", "getId", "setId", "mediaUri", "getMediaUri", "setMediaUri", "picture", "getPicture", "pictureUri", "getPictureUri", "rating", "getRating", "station", "getStation", "setStation", "stationPicture", "getStationPicture", "(Landroid/support/v4/media/MediaMetadataCompat$Builder;)Landroid/graphics/Bitmap;", "setStationPicture", "(Landroid/support/v4/media/MediaMetadataCompat$Builder;Landroid/graphics/Bitmap;)V", "stationPictureUri", "getStationPictureUri", "setStationPictureUri", "title", "getTitle", "setTitle", "userRating", "getUserRating", "writer", "getWriter", "year", "getYear", "toMediaSource", "Lcom/google/android/exoplayer2/source/ExtractorMediaSource;", "kotlin.jvm.PlatformType", "dataSourceFactory", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "Lcom/google/android/exoplayer2/source/ConcatenatingMediaSource;", "", "shared_debug"})
public final class MediaMetaDataUtilsKt {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String METADATA_KEY_UAMP_FLAGS = "com.example.android.uamp.media.METADATA_KEY_UAMP_FLAGS";
    
    /**
     * Useful extensions for [MediaMetadataCompat.Builder].
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NO_GET = "Property does not have a \'get\'";
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getId(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getTitle(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$title) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getArtist(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$artist) {
        return null;
    }
    
    public static final long getDuration(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$duration) {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getStation(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$station) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getAuthor(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$author) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getWriter(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$writer) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getComposer(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$composer) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getCompilation(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$compilation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getDate(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$date) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getYear(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$year) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getGenre(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$genre) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getAlbumArtist(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$albumArtist) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.graphics.Bitmap getPicture(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$picture) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.net.Uri getPictureUri(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$pictureUri) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final android.graphics.Bitmap getStationPicture(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$stationPicture) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.net.Uri getStationPictureUri(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$stationPictureUri) {
        return null;
    }
    
    public static final long getUserRating(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$userRating) {
        return 0L;
    }
    
    public static final long getRating(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$rating) {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getDisplayTitle(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$displayTitle) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getDisplaySubtitle(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$displaySubtitle) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getDisplayDescription(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$displayDescription) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.graphics.Bitmap getDisplayIcon(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$displayIcon) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.net.Uri getDisplayIconUri(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$displayIconUri) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.net.Uri getMediaUri(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$mediaUri) {
        return null;
    }
    
    public static final long getDownloadStatus(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$downloadStatus) {
        return 0L;
    }
    
    /**
     * Custom property for storing whether a [MediaMetadataCompat] item represents an
     * item that is [MediaItem.FLAG_BROWSABLE] or [MediaItem.FLAG_PLAYABLE].
     */
    @android.support.v4.media.MediaBrowserCompat.MediaItem.Flags()
    public static void flag$annotations(android.support.v4.media.MediaMetadataCompat p0) {
    }
    
    public static final int getFlag(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$flag) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getId(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$id) {
        return null;
    }
    
    public static final void setId(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$id, @org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getTitle(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$title) {
        return null;
    }
    
    public static final void setTitle(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$title, @org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getArtist(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$artist) {
        return null;
    }
    
    public static final void setArtist(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$artist, @org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getStation(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$station) {
        return null;
    }
    
    public static final void setStation(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$station, @org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    public static final long getDuration(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$duration) {
        return 0L;
    }
    
    public static final void setDuration(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$duration, long value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getGenre(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$genre) {
        return null;
    }
    
    public static final void setGenre(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$genre, @org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getMediaUri(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$mediaUri) {
        return null;
    }
    
    public static final void setMediaUri(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$mediaUri, @org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getStationPictureUri(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$stationPictureUri) {
        return null;
    }
    
    public static final void setStationPictureUri(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$stationPictureUri, @org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final android.graphics.Bitmap getStationPicture(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$stationPicture) {
        return null;
    }
    
    public static final void setStationPicture(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$stationPicture, @org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getDisplayTitle(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$displayTitle) {
        return null;
    }
    
    public static final void setDisplayTitle(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$displayTitle, @org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getDisplaySubtitle(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$displaySubtitle) {
        return null;
    }
    
    public static final void setDisplaySubtitle(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$displaySubtitle, @org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getDisplayDescription(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$displayDescription) {
        return null;
    }
    
    public static final void setDisplayDescription(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$displayDescription, @org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getDisplayIconUri(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$displayIconUri) {
        return null;
    }
    
    public static final void setDisplayIconUri(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$displayIconUri, @org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    public static final long getDownloadStatus(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$downloadStatus) {
        return 0L;
    }
    
    public static final void setDownloadStatus(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$downloadStatus, long value) {
    }
    
    @android.support.v4.media.MediaBrowserCompat.MediaItem.Flags()
    public static void flag$annotations(android.support.v4.media.MediaMetadataCompat.Builder p0) {
    }
    
    public static final int getFlag(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$flag) {
        return 0;
    }
    
    public static final void setFlag(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat.Builder $this$flag, int value) {
    }
    
    /**
     * Extension method for building an [ExtractorMediaSource] from a [MediaMetadataCompat] object.
     *
     * For convenience, place the [MediaDescriptionCompat] into the tag so it can be retrieved later.
     */
    public static final com.google.android.exoplayer2.source.ExtractorMediaSource toMediaSource(@org.jetbrains.annotations.NotNull()
    android.support.v4.media.MediaMetadataCompat $this$toMediaSource, @org.jetbrains.annotations.NotNull()
    com.google.android.exoplayer2.upstream.DataSource.Factory dataSourceFactory) {
        return null;
    }
    
    /**
     * Extension method for building a [ConcatenatingMediaSource] given a [List]
     * of [MediaMetadataCompat] objects.
     */
    @org.jetbrains.annotations.NotNull()
    public static final com.google.android.exoplayer2.source.ConcatenatingMediaSource toMediaSource(@org.jetbrains.annotations.NotNull()
    java.util.List<android.support.v4.media.MediaMetadataCompat> $this$toMediaSource, @org.jetbrains.annotations.NotNull()
    com.google.android.exoplayer2.upstream.DataSource.Factory dataSourceFactory) {
        return null;
    }
}
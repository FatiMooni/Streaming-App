package com.tima.streaming.shared.utils;

import java.lang.System;

/**
 * Source of [MediaMetadataCompat] objects created from a basic JSON stream.
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014H\u0096\u0002J\u0011\u0010\u0015\u001a\u00020\u0016H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J!\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tima/streaming/shared/utils/JsonSource;", "Lcom/tima/streaming/shared/AbstractStreamingSource;", "context", "Landroid/content/Context;", "source", "Landroid/net/Uri;", "(Landroid/content/Context;Landroid/net/Uri;)V", "glide", "Lcom/bumptech/glide/RequestManager;", "playList", "", "Landroid/support/v4/media/MediaMetadataCompat;", "getPlayList", "()Ljava/util/List;", "setPlayList", "(Ljava/util/List;)V", "downloadJson", "Lcom/tima/streaming/shared/models/JsonPlayList;", "sourceUri", "iterator", "", "load", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCatalog", "catalogUri", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "shared_debug"})
public final class JsonSource extends com.tima.streaming.shared.AbstractStreamingSource {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<android.support.v4.media.MediaMetadataCompat> playList;
    private final com.bumptech.glide.RequestManager glide = null;
    private final android.net.Uri source = null;
    private static final int NOTIFICATION_LARGE_ICON_SIZE = 144;
    private static final com.bumptech.glide.request.RequestOptions glideOptions = null;
    public static final com.tima.streaming.shared.utils.JsonSource.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<android.support.v4.media.MediaMetadataCompat> getPlayList() {
        return null;
    }
    
    public final void setPlayList(@org.jetbrains.annotations.NotNull()
    java.util.List<android.support.v4.media.MediaMetadataCompat> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.Iterator<android.support.v4.media.MediaMetadataCompat> iterator() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object load(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p0) {
        return null;
    }
    
    /**
     * Attempts to download a playlist / stations list from a given Uri.
     * @param sourceUri URI to attempt to download the whole playlist.
     * @return The playlist downloaded, or an empty list if an error occurred.
     */
    private final com.tima.streaming.shared.models.JsonPlayList downloadJson(android.net.Uri sourceUri) throws java.io.IOException {
        return null;
    }
    
    public JsonSource(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.net.Uri source) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tima/streaming/shared/utils/JsonSource$Companion;", "", "()V", "NOTIFICATION_LARGE_ICON_SIZE", "", "glideOptions", "Lcom/bumptech/glide/request/RequestOptions;", "shared_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}
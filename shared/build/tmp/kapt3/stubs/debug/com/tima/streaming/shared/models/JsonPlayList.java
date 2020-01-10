package com.tima.streaming.shared.models;

import java.lang.System;

/**
 * Wrapper object for our JSON in order to be processed easily by GSON.
 * this class has two main parts [default_playlist] & [playlists] according to the API response
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tima/streaming/shared/models/JsonPlayList;", "", "()V", "default_playlist", "Lcom/tima/streaming/shared/models/JsonMusic;", "getDefault_playlist", "()Lcom/tima/streaming/shared/models/JsonMusic;", "setDefault_playlist", "(Lcom/tima/streaming/shared/models/JsonMusic;)V", "playlists", "", "getPlaylists", "()Ljava/util/List;", "setPlaylists", "(Ljava/util/List;)V", "shared_debug"})
public final class JsonPlayList {
    @org.jetbrains.annotations.Nullable()
    private com.tima.streaming.shared.models.JsonMusic default_playlist;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.tima.streaming.shared.models.JsonMusic> playlists;
    
    @org.jetbrains.annotations.Nullable()
    public final com.tima.streaming.shared.models.JsonMusic getDefault_playlist() {
        return null;
    }
    
    public final void setDefault_playlist(@org.jetbrains.annotations.Nullable()
    com.tima.streaming.shared.models.JsonMusic p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.tima.streaming.shared.models.JsonMusic> getPlaylists() {
        return null;
    }
    
    public final void setPlaylists(@org.jetbrains.annotations.NotNull()
    java.util.List<com.tima.streaming.shared.models.JsonMusic> p0) {
    }
    
    public JsonPlayList() {
        super();
    }
}
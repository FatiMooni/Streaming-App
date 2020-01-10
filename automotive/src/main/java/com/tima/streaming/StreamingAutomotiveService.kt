package com.tima.streaming

import android.app.Activity
import android.content.ComponentName
import com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector
import com.tima.streaming.shared.StreamingService
import com.tima.streaming.shared.connection.MediaSessionConnection
import kotlinx.coroutines.ExperimentalCoroutinesApi

class StreamingAutomotiveService : StreamingService() {

    @ExperimentalCoroutinesApi
    override fun onCreate() {
        super.onCreate()
         val applicationContext = application.applicationContext
         val mediaSessionConnection = MediaSessionConnection(
            applicationContext,
            ComponentName(applicationContext, StreamingAutomotiveService::class.java)
        )

        //mediaSessionConnection.
    }
}
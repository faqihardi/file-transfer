package com.example.filetransfer

import android.app.Application
import com.example.filetransfer.data.repository.HistoryRecorder
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class P2pApp : Application() {

    @Inject
    lateinit var historyRecorder: HistoryRecorder

    override fun onCreate() {
        super.onCreate()
        historyRecorder.start()
    }
}
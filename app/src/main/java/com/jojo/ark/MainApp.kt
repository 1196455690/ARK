package com.jojo.ark

import android.app.Application
import android.content.Context
import com.jojo.uikit.log.LogCat
import dagger.hilt.android.HiltAndroidApp

/**
 * @author JOJO
 * @date 2020/3/10
 */
@HiltAndroidApp
class MainApp : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        initConfig()
    }

    private fun initConfig() {
        initLog()
        initToast()
    }

    private fun initLog() {
        if (!BuildConfig.DEBUG) {
            LogCat.shutdown()
        }
    }

    private fun initToast() {
        // TODO: init Toaster
    }


}
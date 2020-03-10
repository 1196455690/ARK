package com.jojo.ark

import android.app.Application
import android.content.Context

/**
 * @author JOJO
 * @date 2020/3/10
 */
class MyApp : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }

    override fun onCreate() {
        super.onCreate()
    }

}
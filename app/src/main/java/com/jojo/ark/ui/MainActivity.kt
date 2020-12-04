package com.jojo.ark.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.jojo.ark.R
import com.jojo.ark.android.AndroidActivity
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.OkHttpClient
import javax.inject.Inject


/**
 * @author JOJO
 * @date 2020/3/10
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    @Inject
    lateinit var okHttpClient: OkHttpClient

    override fun onStart() {
        super.onStart()
        startActivity(Intent(this, AndroidActivity::class.java))
    }
}

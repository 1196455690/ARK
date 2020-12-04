package com.jojo.ark.android.leakcanary

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jojo.ark.R

/**
 * @author JOJO
 * @date 2020/5/27
 */
class LeakActivity : AppCompatActivity(R.layout.activity_leak_main), View.OnClickListener {

    override fun onClick(v: View?) {
        if (v == null) return
        when (v.id) {
            R.id.btn0 -> {
                startActivity(Intent(this, Leak0Activity::class.java))
            }
            R.id.btn1 -> {
                startActivity(Intent(this, Leak1Activity::class.java))
            }
            R.id.btn2 -> {
                startActivity(Intent(this, Leak2Activity::class.java))
            }
            R.id.btn3 -> {
                startActivity(Intent(this, Leak3Activity::class.java))
            }
        }
    }
}
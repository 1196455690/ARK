package com.jojo.ark.android.eventbus

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jojo.ark.R
import com.jojo.uikit.log.LogCat
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * @author JOJO
 */
class EventBusActivity : AppCompatActivity(R.layout.activity_eventbus), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    override fun onClick(v: View?) {
        if (v == null) return
        when (v.id) {
            R.id.btn_send -> {
                LogCat.d("post event")
                EventBus.getDefault().post(MessageEvent(100))
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: MessageEvent) {
        LogCat.d("onMessageEvent: $event")
    }

}
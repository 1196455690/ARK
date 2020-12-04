package com.jojo.uikit.toast

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast

/**
 * @author JOJO
 * @date 2020/3/17
 */
class Toaster {
    // TODO: 自定义Toast样式

    companion object {
        private var mToast: Toast? = null

        fun show(context: Context, msg: String?) {
            show(context, msg, Toast.LENGTH_SHORT)
        }

        fun showLong(context: Context, msg: String?) {
            show(context, msg, Toast.LENGTH_LONG)
        }

        @SuppressLint("ShowToast")
        fun show(context: Context, msg: String?, duration: Int) {
            mToast?.apply {
                if (view?.isShown == true) {
                    mToast?.cancel()
                }
            }
            mToast = Toast.makeText(context.applicationContext, msg, duration).apply { show() }
        }
    }
}
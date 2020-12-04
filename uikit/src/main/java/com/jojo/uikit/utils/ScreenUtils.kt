package com.jojo.uikit.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * @author zhoupeng
 * @date 2020/11/27
 */
class ScreenUtils private constructor() {

    companion object {

        @JvmStatic
        fun getStatusBarHeight(context: Context): Int {
            context.resources.apply {
                val id = getIdentifier("status_bar_height", "dimen", "android")
                if (id > 0) {
                    //根据资源ID获取响应的尺寸值
                    return getDimensionPixelSize(id);
                }
            }
            return 0
        }

        @JvmStatic
        fun getScreenWidth(context: Context): Int {
            val wm: WindowManager =
                context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val dm = DisplayMetrics()
            wm.defaultDisplay.getMetrics(dm)
            return dm.widthPixels
        }

        @JvmStatic
        fun getScreenHeight(context: Context): Int {
            val wm: WindowManager =
                context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val dm = DisplayMetrics()
            wm.defaultDisplay.getMetrics(dm)
            return dm.heightPixels
        }
    }
}
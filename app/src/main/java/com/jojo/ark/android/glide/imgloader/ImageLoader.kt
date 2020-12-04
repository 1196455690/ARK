package com.jojo.ark.android.glide.imgloader

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.text.TextUtils
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

/**
 * @author JOJO
 * @date 2020/6/11
 */
class ImageLoader private constructor() : AbsImageLoader() {
    companion object {
        val instance: ImageLoader by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            ImageLoader()
        }
    }

    override fun downloadImage(urlStr: String?): Bitmap? {
        if (TextUtils.isEmpty(urlStr)) return null

        val url = URL(urlStr)
        var connection: HttpURLConnection? = null
        var input: InputStream? = null
        try {
            connection = url.openConnection() as HttpURLConnection
            input = connection.inputStream
            return BitmapFactory.decodeStream(input)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            if (connection != null) {
                connection.disconnect()
                connection = null
            }
            if (input != null) {
                input.close()
                input = null
            }
        }

        return null
    }
}
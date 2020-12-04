package com.jojo.ark.android.glide.imgloader

import android.graphics.Bitmap
import android.os.AsyncTask
import android.widget.ImageView
import okhttp3.internal.notifyAll
import okhttp3.internal.wait
import java.lang.ref.WeakReference

/**
 * @author JOJO
 * @date 2020/6/11
 */
abstract class AbsImageLoader {
    /** 暂停工作 */
    protected var isPauseWork = false

    fun load(url: String?, imageView: ImageView) {
        val imageLoadTask = BitmapLoadTask(url, WeakReference(imageView))
        imageLoadTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR)
    }

    private inner class BitmapLoadTask(
        private val url: String?,
        private val imageViewRef: WeakReference<ImageView>
    ) : AsyncTask<Void, Void, Bitmap>() {
        override fun doInBackground(vararg params: Void?): Bitmap? {
            synchronized(this@AbsImageLoader) {
                while (isPauseWork) {
                    try {
                        wait()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
            return downloadImage(url)
        }

        override fun onPostExecute(result: Bitmap?) {
            super.onPostExecute(result)
            result?.let {
                imageViewRef.get()?.setImageBitmap(it)
            }
        }

        override fun onCancelled(result: Bitmap?) {
            super.onCancelled(result)
            synchronized(this@AbsImageLoader) {
                notifyAll()
            }
        }
    }

    protected abstract fun downloadImage(urlStr: String?): Bitmap?

    fun pauseWork(isPause: Boolean) {
        synchronized(this) {
            isPauseWork = isPause
            if (!isPauseWork) {
                notifyAll()
            }
        }
    }
}
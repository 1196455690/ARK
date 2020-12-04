package com.jojo.ark.android.demo

import android.content.Context
import android.os.Bundle
import android.view.Gravity.CENTER
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.Button
import android.widget.LinearLayout
import android.widget.LinearLayout.VERTICAL
import androidx.appcompat.app.AppCompatActivity
import com.jojo.uikit.log.LogCat
import com.jojo.uikit.toast.Toaster
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * @author JOJO
 * @date 2020/8/11
 * File Descriptor Leak
 *
 * 常用指令：
 * adb shell
 * dumpsys meminfo <package name>
 * cd /proc/<pid>/fd
 * ls | wc -l
 * ls -al
 *
 */
class FdLeakDemoActivity : AppCompatActivity() {
    private var num = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this)

        setContentView(root)

        root.apply {
            layoutParams.height = MATCH_PARENT
            layoutParams.width = MATCH_PARENT
            gravity = CENTER
            orientation = VERTICAL
        }

        addViews(root, Button(this).apply {
            text = "I/O Leak"
            setOnClickListener { leakIO() }
        }, Button(this).apply {
            text = "Thread Leak"
            setOnClickListener { leakThread() }
        }, Button(this).apply {
            text = "InputChannel Leak"
            setOnClickListener { leakInputChannel() }
        })

        num = 1
    }

    private fun addViews(parent: ViewGroup, vararg views: View) {
        for (i in views) {
            parent.addView(i)
        }
    }

    private fun leakIO() {
        Toaster.show(this, "I/O Leak")
        writeIO("text.txt")
//        readIO("text.txt")
    }

    /**
     * I/O泄露时，[ls -l]中出现大量<file name>路径，一次I/O对应FD+1，close时回收
     */
    private fun readIO(name: String) {
        var stream: FileInputStream? = null
        try {
            stream = openFileInput(name)
            LogCat.d("file input ${stream.read()}")
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            stream?.close()
        }
    }


    /**
     * I/O泄露时，[ls -l]中出现大量socket，一次I/O对应FD+1，close时回收
     */
    private fun writeIO(name: String) {
        var stream: FileOutputStream? = null
        try {
            stream = openFileOutput(name, Context.MODE_PRIVATE)
            val message = "This is a new text file"
            stream.write(message.toByteArray())
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            stream?.close()
        }
    }


    private val pool = ThreadPoolExecutor(
        3, 6, 5, TimeUnit.SECONDS, LinkedBlockingQueue()
    )

    /**
     * Thread泄漏时，[ls -l]中出现大量anon_inode，quit时释放句柄
     */
    private fun leakThread() {
        LogCat.d("leakThread " + num++)
        // HandlerThread默认持有Loop
//        val handlerThread = HandlerThread("My HandlerThread")
//        handlerThread.start()
        // 退出HandlerThread释放句柄资源
//        handlerThread.quitSafely()
//        handlerThread.quit()

//        val thread = Thread {
//            Looper.prepare()
//            LogCat.d("Thread start ${num++}")
//            Looper.loop()
//        }
//        thread.start()

        pool.execute {
            LogCat.d("Thread pool start ${num++}")
        }
//        pool.shutdown()
    }

    private fun leakInputChannel() {
        Toaster.show(this, "InputChannel Leak")
    }
}
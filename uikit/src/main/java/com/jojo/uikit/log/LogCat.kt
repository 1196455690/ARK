package com.jojo.uikit.log

import android.text.TextUtils
import android.util.Log
import org.json.JSONArray
import org.json.JSONObject
import java.io.StringReader
import java.io.StringWriter
import javax.xml.transform.OutputKeys
import javax.xml.transform.TransformerFactory
import javax.xml.transform.stream.StreamResult
import javax.xml.transform.stream.StreamSource

/**
 * @author JOJO
 * @date 2020/6/8
 */
class LogCat private constructor() {
    companion object {
        private val TAG = "LogCat"
        private var isOpen = true
        private const val JSON_INDENT_SPACES = 2

        fun v(msg: String?) {
            if (!isLogOpen()) return
            Log.v(TAG, msg ?: "")
        }

        fun d(msg: String?) {
            if (!isLogOpen()) return
            Log.d(TAG, msg ?: "")
        }

        fun i(msg: String?) {
            if (!isLogOpen()) return
            Log.i(TAG, msg ?: "")
        }

        fun w(msg: String?) {
            if (!isLogOpen()) return
            Log.w(TAG, msg ?: "")
        }

        fun e(msg: String?) {
            if (!isLogOpen()) return
            Log.e(TAG, msg ?: "")
        }

        private fun isLogOpen(): Boolean {
            return isOpen
        }

        fun shutdown() {
            isOpen = false
        }

        private fun json(jsonStr: String?) {
            if (null == jsonStr || TextUtils.isEmpty(jsonStr)) return d("Empty/Null JSON content !")
            try {
                val json = jsonStr.trim()
                if (json.startsWith("{")) {
                    val jsonObject = JSONObject(json)
                    val message = jsonObject.toString(JSON_INDENT_SPACES)
                    d(message)
                    return
                }
                if (json.startsWith("[")) {
                    val jsonArray = JSONArray(json)
                    val message = jsonArray.toString(JSON_INDENT_SPACES)
                    d(message)
                    return
                }
                e("Invalid JSON !")
            } catch (e: Exception) {
                e.printStackTrace()
                e("Invalid JSON: " + e.message)
            }
        }

        private fun xml(xmlStr: String?) {
            if (null == xmlStr || TextUtils.isEmpty(xmlStr)) return d("Empty/Null xml content !")
            try {
                val xmlInput = StreamSource(StringReader(xmlStr))
                val xmlOutput = StreamResult(StringWriter())
                val transformer = TransformerFactory.newInstance().newTransformer()
                transformer.setOutputProperty(OutputKeys.INDENT, "yes")
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2")
                transformer.transform(xmlInput, xmlOutput)
                d(xmlOutput.writer.toString().replaceFirst(">".toRegex(), ">\n"))
            } catch (e: Exception) {
                e.printStackTrace()
                e("Invalid xml")
            }
        }
    }

}
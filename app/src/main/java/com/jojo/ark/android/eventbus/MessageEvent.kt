package com.jojo.ark.android.eventbus

/**
 * @author JOJO
 */
class MessageEvent(val code: Int, val msg: String? = null) {
    override fun toString(): String {
        return "MessageEvent(code=$code, msg=$msg)"
    }
}
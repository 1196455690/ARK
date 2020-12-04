package com.lib.ime

import android.inputmethodservice.InputMethodService
import android.view.inputmethod.EditorInfo
import com.lib.ime.input.InputEventHandler
import com.lib.ime.view.cand.CandidateView
import com.lib.ime.view.keymap.SoftKeyboardView

/**
 * @author JOJO
 * @date 2020/5/13
 */
class ImeService : InputMethodService(), Runnable {
    private var inputEventHandler: InputEventHandler? = null

    private var softView: SoftKeyboardView? = null
    private var candView: CandidateView? = null

    override fun onCreate() {
        super.onCreate()

        initSkinRender()

        inputEventHandler = InputEventHandler()

        initCandState()

        if (softView == null) {
            initSoftKeyboardView()
        }

        if (candView == null) {
            initCandidateView()
        }

    }

    private fun initSkinRender() {
        // TODO: 皮肤是如何加载到键盘上的？
    }

    private fun initCandState() {
        // TODO: Cand条如何定位？
    }

    private fun initSoftKeyboardView() {
        // TODO: 键盘样式如何绘制？
        softView = SoftKeyboardView()

    }

    private fun initCandidateView() {
        // TODO: Cand如何绘制？
        candView = CandidateView()

    }

    private fun initKeymapViewManager() {

    }

    override fun onStartInput(attribute: EditorInfo?, restarting: Boolean) {
        super.onStartInput(attribute, restarting)
    }

    override fun onStartInputView(info: EditorInfo?, restarting: Boolean) {
        super.onStartInputView(info, restarting)
    }

    private fun onStartInputViewInternal() {

    }

    override fun onFinishInput() {
        super.onFinishInput()
        // 停止操作
    }

    override fun onDestroy() {
        super.onDestroy()
        // 释放资源
    }

    override fun run() {

    }
}
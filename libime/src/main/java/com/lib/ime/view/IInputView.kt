package com.lib.ime.view

import android.graphics.Canvas
import android.view.MotionEvent

/**
 * @author JOJO
 * @date 2020/5/20
 */
interface IInputView {

    fun dispatchTouchEvent(event: MotionEvent): Boolean

    fun draw(canvas: Canvas)

    fun onDraw(canvas: Canvas)

    fun onMeasure()
}
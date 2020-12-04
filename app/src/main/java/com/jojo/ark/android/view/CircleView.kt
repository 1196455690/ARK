package com.jojo.ark.android.view

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewGroup
import android.widget.Scroller

/**
 * @author zhoupeng
 * @date 2020/11/27
 *
 * TODO 功能实现：
 * 1、单指拖拽
 * 2、靠边吸附
 * 3、惯性滑动
 * 4、阻尼回弹
 */
class CircleView : ViewGroup {
    private var lastX: Float = 0f
    private var lastY: Float = 0f

    private var offsetX: Float = 0f
    private var offsetY: Float = 0f

    private var mScroller: Scroller? = null

    private val mTouchSlop: Int
        get() = ViewConfiguration.get(context).scaledPagingTouchSlop

    constructor(context: Context?) : this(context, null)

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    ) {
        init()
    }

    private fun init() {
        isClickable = true
        mScroller = Scroller(context)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event == null) return false

        val mX: Float = event.rawX
        val mY: Float = event.rawY

        when (event.action) {
            MotionEvent.ACTION_MOVE -> {
                // 计算偏移量，右移为正数，左移为负数
                offsetX = mX - lastX
                offsetY = mY - lastY
                offsetLeftAndRight(offsetX.toInt());
                offsetTopAndBottom(offsetY.toInt());
            }
            MotionEvent.ACTION_UP -> {
                // 手指离开时，执行回到远点的滑动过程
                val animator1: ObjectAnimator =
                    ObjectAnimator.ofFloat(this, "translationX", -left.toFloat())
                val animator2: ObjectAnimator =
                    ObjectAnimator.ofFloat(this, "translationY", -top.toFloat())
                val set = AnimatorSet()
                set.playTogether(animator1, animator2)
                set.start()
            }
        }

        lastX = mX
        lastY = mY

        return true
    }

    override fun computeScroll() {
        super.computeScroll()
        mScroller?.apply {
            if (computeScrollOffset()) {
                (parent as View).scrollTo(currX, currY)
                invalidate()
            }
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

    }

    override fun onDetachedFromWindow() {
        mScroller = null
        super.onDetachedFromWindow()
    }
}
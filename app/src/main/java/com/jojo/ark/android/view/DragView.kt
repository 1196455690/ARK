package com.jojo.ark.android.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import androidx.core.view.ViewCompat
import androidx.customview.widget.ViewDragHelper

/**
 * @author zhoupeng
 * @date 2020/12/4
 */
class DragView : FrameLayout {
    private var mViewDragHelper: ViewDragHelper? = null
    private var mMenuView: View? = null
    private var mMainView: View? = null
    private var mWidth: Int = 0

    private val defaultMenuWidth: Int = 300
    private val defaultOpenMenuSize: Int = 500

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    ) {
        init()
    }

    private fun init() {
        mViewDragHelper = ViewDragHelper.create(this, defCallback)
    }

    private val defCallback: ViewDragHelper.Callback = object : ViewDragHelper.Callback() {
        // 何时开始检测触摸事件
        override fun tryCaptureView(child: View, pointerId: Int): Boolean {
            // 如果当前触摸的child是mMainView时开始检测
            return mMainView == child;
        }

        // 触摸到View后回调
        override fun onViewCaptured(capturedChild: View, activePointerId: Int) {
            super.onViewCaptured(capturedChild, activePointerId)
        }

        // 当拖拽状态改变，比如idle，dragging
        override fun onViewDragStateChanged(state: Int) {
            super.onViewDragStateChanged(state)
        }

        // 当位置改变时调用，常用于滑动时更改scale等
        override fun onViewPositionChanged(
            changedView: View, left: Int, top: Int, dx: Int, dy: Int
        ) {
            super.onViewPositionChanged(changedView, left, top, dx, dy)
        }

        override fun clampViewPositionHorizontal(child: View, left: Int, dx: Int): Int {
            return super.clampViewPositionHorizontal(child, left, dx)
        }

        override fun clampViewPositionVertical(child: View, top: Int, dy: Int): Int {
            return super.clampViewPositionVertical(child, top, dy)
        }

        // 拖动结束后调用
        override fun onViewReleased(releasedChild: View, xvel: Float, yvel: Float) {
            super.onViewReleased(releasedChild, xvel, yvel)
            // 手指抬起后缓慢移动到指定位置
            mMainView?.let {
                if (it.left < defaultOpenMenuSize) {
                    // 关闭菜单，相当于Scroller的startScroll方法
                    mViewDragHelper?.smoothSlideViewTo(it, 0, 0)
                } else {
                    // 打开菜单
                    mViewDragHelper?.smoothSlideViewTo(it, defaultMenuWidth, 0)
                }
                ViewCompat.postInvalidateOnAnimation(this@DragView)
            }
        }
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event == null) return false
        // 将触摸事件传递给ViewDragHelper，此操作必不可少
        mViewDragHelper?.processTouchEvent(event)
        return true
    }

    override fun computeScroll() {
        if (mViewDragHelper?.continueSettling(true) == true) {
            ViewCompat.postInvalidateOnAnimation(this)
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        mMenuView = getChildAt(0)
        mMainView = getChildAt(1)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mMenuView?.let {
            mWidth = it.measuredWidth
        }
    }


}
package wyl.autofitviewpager.kotlin.autofitviewpager

import android.content.Context
import android.support.v4.view.ViewPager
import android.view.View

class AutoFitViewPager(context: Context) : ViewPager(context) {

    init {
        addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
                requestLayout()
            }

            override fun onPageSelected(p0: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val view = getChildAt(currentItem)
        view?.measure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(measuredWidth, measureHeight(heightMeasureSpec, view))
    }

    //重新测量高度
    private fun measureHeight(measureSpec: Int, view: View): Int {
        var height: Int = 0
        val specMode: Int = MeasureSpec.getMode(measureSpec)
        val specSize: Int = MeasureSpec.getSize(measureSpec)
        if (specMode == MeasureSpec.EXACTLY) {
            height = specSize
        } else {
            height = view?.measuredHeight
            if (specMode == MeasureSpec.AT_MOST) {
                height = Math.min(height, specSize)
            }
        }
        return height
    }
}
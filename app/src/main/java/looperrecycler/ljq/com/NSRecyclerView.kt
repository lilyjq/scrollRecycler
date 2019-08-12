package looperrecycler.ljq.com

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by ljq
 * on 2019/8/12.
 * <p> </p>
 */
class NSRecyclerView : RecyclerView {

    constructor(context: Context?):super(context)
    constructor(context: Context?,attrs:AttributeSet?):super(context,attrs)
    constructor(context: Context?,attrs: AttributeSet?,defStyleAttr:Int):super(context,attrs,defStyleAttr)


    var x1:Float? = null
    var x2:Float? = null
    var y1:Float? = null
    var y2:Float? = null

    override fun onTouchEvent(e: MotionEvent?): Boolean {
        when(e?.action){
            MotionEvent.ACTION_DOWN ->{
                x1 = e.x
                y1 = e.y
            }
            MotionEvent.ACTION_MOVE ->{
                return  false;//不管移动事件
            }
            MotionEvent.ACTION_UP ->{
                x2 = e.x
                y2 = e.y
                var x3 = x1?.minus(x2!!)
                var y3 = y1?.minus(y2!!)
                if(Math.abs(x3!!)>50 || Math.abs(y3!!)>50) {
                    return false//有滑动的时候返回false
                }
            }

        }
        return super.onTouchEvent(e)
    }
}
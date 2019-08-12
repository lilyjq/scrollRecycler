package looperrecycler.ljq.com

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.WeakReference
import java.util.ArrayList

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var manger = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL)
        dm.adapter = DmAdapter(this,initData())
        dm.layoutManager = manger
        handler = DmHandler(this)
        handler.sendEmptyMessageDelayed(1,1500)


    }


    fun initData() :List<String> {
        var list:List<String>  = listOf("井底引银瓶","银瓶欲上丝绳绝","石上磨玉簪，玉簪欲成中央折。",
                "忆昔在家为女时，人言举动有殊姿。","相见初经田窦家，侯门歌舞出如花。许将戚里箜篌伎，等取将军油壁车",
                "明月几时有？","把酒问青天","水陆草木之花，可爱者甚蕃","怒发冲冠，凭栏处、潇潇雨歇。",
                "壮志饥餐胡虏肉，笑谈渴饮匈奴血.","靖康耻，犹未雪","爆竹声中一岁除，春风送暖入屠苏。",
                "庆历四年春，滕子京谪守巴陵郡","若夫淫雨霏霏，连月不开，阴风怒号，浊浪排空；","至若春和景明，波澜不惊，上下天光，一碧万顷；",
                "噫！微斯人，吾谁与归？","沙鸥翔集，锦鳞游泳；","至于负者歌于途，行者休于树，前者呼，后者应","太守谓谁？庐陵欧阳修也。",
                "大江东去，浪淘尽.")
        return list

    }
    lateinit var handler: DmHandler

 class DmHandler(aty:MainActivity):Handler(){
     var weakReference:WeakReference<MainActivity>? = null
     init {
         weakReference = WeakReference(aty)
     }

     override fun handleMessage(msg: Message?) {
         var aty = weakReference!!.get()
         if(aty!=null){
             if(aty.dm != null) {
                 aty.dm.scrollBy(2, 0)
                 aty.handler.sendEmptyMessageDelayed(1, 16)
             }
             }
     }
 }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}

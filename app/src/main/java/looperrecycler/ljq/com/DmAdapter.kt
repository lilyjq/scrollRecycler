package looperrecycler.ljq.com

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by ljq
 * on 2019/8/12.
 * <p> </p>
 */
class DmAdapter(var context:Context,var list: List<String>) : RecyclerView.Adapter<DmAdapter.DmViewHolder>() {


    override fun onBindViewHolder(holder: DmViewHolder, position: Int) {
        var pos = position
        if(pos > list.size-1){
            pos = pos%(list.size)
        }
       // Log.e("pos",pos.toString()+"      "+list.size.toString())
        holder.tv.text = list[pos]
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DmViewHolder {
        var view:View = LayoutInflater.from(context).inflate(R.layout.item_view,parent,false)
        return DmViewHolder(view)
    }


    public class DmViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
         var tv: TextView
        init {
            tv = itemView!!.findViewById(R.id.dm_item)

        }

    }
}
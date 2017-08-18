package wenge.com.testkotlin.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import wenge.com.testkotlin.domian.model.ForecastList

/**
 * Created by WENGE on 2017/8/17.
 * 备注：
 */

class RvAdapter(val weekForecast:ForecastList):RecyclerView.Adapter<RvAdapter.Viewholder>(){
    override fun onBindViewHolder(holder: Viewholder?, position: Int) {
//        with(weekForecast.dailyForecast[position]) {
//            holder!!.textView.text="$date - $description - $high/$low"
//        }
        with(weekForecast[position]) {
            holder!!.textView.text = "$date - $description - $high/$low"
        }
    }

    override fun getItemCount(): Int = weekForecast.size()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Viewholder {
        return Viewholder(TextView(parent!!.getContext()))
    }

    class Viewholder(val textView :TextView):RecyclerView.ViewHolder(textView)
}
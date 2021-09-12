package co.nimblehq.sample.ui.surveylist

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.nimblehq.surveysdk.entity.SurveyListEntity

class SurveyAdapter : RecyclerView.Adapter<SurveyAdapter.SurveyViewHolder>() {
    private val dataList = mutableListOf<SurveyListEntity.SurveyListItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurveyViewHolder {
        return SurveyViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: SurveyViewHolder, position: Int) {
        holder.bind(dataList[position].attributes?.title ?: "")
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun updateData(list: List<SurveyListEntity.SurveyListItem>) {
        val start = dataList.size
        dataList.addAll(list)
        notifyItemRangeChanged(start, dataList.size)
    }

    class SurveyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(value: String) {
            (itemView as TextView).text = value
        }
    }
}
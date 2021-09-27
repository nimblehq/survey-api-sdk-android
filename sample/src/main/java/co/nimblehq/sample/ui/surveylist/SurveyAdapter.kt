package co.nimblehq.sample.ui.surveylist

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.nimblehq.sample.ID_KEY
import co.nimblehq.sample.TITLE_KEY
import co.nimblehq.sample.ui.surveydetail.SurveyDetailActivity
import co.nimblehq.survey.sdk.model.SurveyModel

class SurveyAdapter : RecyclerView.Adapter<SurveyAdapter.SurveyViewHolder>() {

    private val dataList = mutableListOf<SurveyModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurveyViewHolder {
        val textView = TextView(parent.context)
        textView.textSize = 24f
        return SurveyViewHolder(textView)
    }

    override fun onBindViewHolder(holder: SurveyViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun updateData(list: List<SurveyModel>) {
        val start = dataList.size
        dataList.addAll(list)
        notifyItemRangeChanged(start, dataList.size)
    }

    class SurveyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(value: SurveyModel) {
            (itemView as TextView).text = value.surveyTitle
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, SurveyDetailActivity::class.java).apply {
                    putExtra(ID_KEY, value.surveyId)
                    putExtra(TITLE_KEY, value.surveyTitle)
                }
                itemView.context.startActivity(intent)
            }
        }
    }
}

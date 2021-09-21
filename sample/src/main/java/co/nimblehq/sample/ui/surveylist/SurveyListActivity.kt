package co.nimblehq.sample.ui.surveylist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import co.nimblehq.sample.databinding.ActivitySurveyListBinding

class SurveyListActivity : AppCompatActivity() {

    private lateinit var surveyListViewModel: SurveyListViewModel
    private lateinit var binding: ActivitySurveyListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySurveyListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Survey List"

        surveyListViewModel = ViewModelProvider(this, SurveyListModelFactory())
            .get(SurveyListViewModel::class.java)

        surveyListViewModel.surveyListResult.observe(this@SurveyListActivity,{
            it.success?.let { result ->
                (binding.surveyListView.adapter as SurveyAdapter).updateData(result)
            }
        })

        binding.surveyListView.adapter = SurveyAdapter()

    }

}

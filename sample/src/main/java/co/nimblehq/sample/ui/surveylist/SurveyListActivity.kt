package co.nimblehq.sample.ui.surveylist

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
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

        surveyListViewModel.surveyListResult.observe(this@SurveyListActivity, {
            it.success?.let { model ->
                (binding.surveyListView.adapter as SurveyAdapter).updateData(model.listSurvey)
            } ?: Toast.makeText(this, "Error on getting Survey List!", Toast.LENGTH_LONG).show()

        })
        binding.surveyListView.adapter = SurveyAdapter()
        binding.surveyListView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        surveyListViewModel.getSurveyList()
    }

}


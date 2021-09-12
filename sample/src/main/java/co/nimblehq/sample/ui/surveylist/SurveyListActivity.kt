package co.nimblehq.sample.ui.surveylist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import co.nimblehq.sample.databinding.ActivitySurveyListBinding

class SurveyListActivity : AppCompatActivity() {

    private lateinit var surveyListViewModel: SurveyListViewModel
    private lateinit var binding: ActivitySurveyListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySurveyListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        surveyListViewModel = ViewModelProvider(this, SurveyListModelFactory())
            .get(SurveyListViewModel::class.java)


        surveyListViewModel.surveyListSurveyUi.observe(this@SurveyListActivity, Observer {
            //TODO: integration
        })
        binding.surveyListView.adapter = SurveyAdapter()

    }
}


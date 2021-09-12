package co.nimblehq.sample.ui.surveydetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import co.nimblehq.sample.databinding.ActivitySurveyDetailBinding

class SurveyDetailActivity : AppCompatActivity() {

    private lateinit var surveyListViewModel: SurveyDetailViewModel
    private lateinit var binding: ActivitySurveyDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySurveyDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.getStringExtra("title")?.let {
            title = it
        }
        surveyListViewModel = ViewModelProvider(this, SurveyDetailModelFactory())
            .get(SurveyDetailViewModel::class.java)

        surveyListViewModel.surveyDetailResult.observe(this@SurveyDetailActivity, {
            //TODO: Handle result
        })
        surveyListViewModel.getSurveyDetail()
    }

}

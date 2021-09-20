package co.nimblehq.sample.ui.surveydetail

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import co.nimblehq.sample.databinding.ActivitySurveyDetailBinding
import co.nimblehq.survey.sdk.Result

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
            if (it is Result.Success) {
                binding.description.text = it.data.description ?: ""
            } else {
                Toast.makeText(this, "Error on getting Survey Detail!", Toast.LENGTH_LONG).show()
            }

        })
        intent.getStringExtra("id")?.let {
            surveyListViewModel.getSurveyDetail(it)
        }

    }

}


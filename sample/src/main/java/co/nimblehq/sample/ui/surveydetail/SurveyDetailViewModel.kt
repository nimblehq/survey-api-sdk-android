package co.nimblehq.sample.ui.surveydetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.nimblehq.survey.sdk.Result
import co.nimblehq.survey.sdk.SurveyApi
import co.nimblehq.survey.sdk.entity.SurveyEntity
import kotlinx.coroutines.DelicateCoroutinesApi

class SurveyDetailViewModel : ViewModel() {

    private val _surveyDetailResult = MutableLiveData<Result<SurveyEntity>>()
    val surveyDetailResult: LiveData<Result<SurveyEntity>> = _surveyDetailResult

    @DelicateCoroutinesApi
    fun getSurveyDetail(id: String) {
        SurveyApi.instance.getSurveyDetail(surveyId = id, onResponse = {
            _surveyDetailResult.value = it
        })

    }

}


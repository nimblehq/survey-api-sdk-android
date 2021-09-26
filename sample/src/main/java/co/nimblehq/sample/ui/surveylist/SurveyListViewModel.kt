package co.nimblehq.sample.ui.surveylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.nimblehq.survey.sdk.Result
import co.nimblehq.survey.sdk.SurveyApi
import co.nimblehq.survey.sdk.model.SurveyModel
import kotlinx.coroutines.DelicateCoroutinesApi

class SurveyListViewModel : ViewModel() {

    init {
        getSurveyList()
    }

    private val _surveyListResult = MutableLiveData<Result<List<SurveyModel>>>()
    val surveyListResult: LiveData<Result<List<SurveyModel>>> = _surveyListResult

    @DelicateCoroutinesApi
    private fun getSurveyList() {
        SurveyApi.instance.getSurveyList(page = 1, size = 10, onResponse = {
            _surveyListResult.value = it
        })
    }
}

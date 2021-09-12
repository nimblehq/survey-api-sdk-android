package co.nimblehq.sample.ui.surveylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.nimblehq.survey.sdk.Result
import co.nimblehq.survey.sdk.SurveyApi
import co.nimblehq.survey.sdk.entity.SurveyEntity
import kotlinx.coroutines.DelicateCoroutinesApi

class SurveyListViewModel : ViewModel() {

    private val _surveyListResult = MutableLiveData<Result<List<SurveyEntity>>>()
    val surveyListResult: LiveData<Result<List<SurveyEntity>>> = _surveyListResult

    @DelicateCoroutinesApi
    fun getSurveyList() {
        SurveyApi.instance.getSurveyList(page = 1, size = 10, onResponse = {
            _surveyListResult.value = it
        } )
    }

}


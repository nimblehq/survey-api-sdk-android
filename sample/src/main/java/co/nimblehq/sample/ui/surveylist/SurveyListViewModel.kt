package co.nimblehq.sample.ui.surveylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.nimblehq.survey.sdk.ResultSdk
import co.nimblehq.survey.sdk.SurveyApi
import co.nimblehq.survey.sdk.entity.SurveyEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SurveyListViewModel : ViewModel() {

    private val _surveyListResult = MutableLiveData<ResultSdk<List<SurveyEntity>>>()
    val surveyListResult: LiveData<ResultSdk<List<SurveyEntity>>> = _surveyListResult

    fun getSurveyList() {
        // can be launched in a separate asynchronous job
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = SurveyApi.instance.getSurveyList(page = 1, size = 10)
                _surveyListResult.postValue(result)
            }
        }

    }

}


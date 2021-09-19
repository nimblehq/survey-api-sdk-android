package co.nimblehq.sample.ui.surveydetail

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

class SurveyDetailViewModel : ViewModel() {

    private val _surveyDetailResult = MutableLiveData<ResultSdk<SurveyEntity>>()
    val surveyDetailResult: LiveData<ResultSdk<SurveyEntity>> = _surveyDetailResult

    fun getSurveyDetail(id: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = SurveyApi.instance.getSurveyDetail(id = id)
                _surveyDetailResult.postValue(result)
            }
        }
    }

}


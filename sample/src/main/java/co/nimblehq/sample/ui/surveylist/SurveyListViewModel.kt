package co.nimblehq.sample.ui.surveylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.nimblehq.sample.ui.ModelResult
import co.nimblehq.survey.sdk.SurveyApi
import co.nimblehq.survey.sdk.entity.SurveyEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import moe.banana.jsonapi2.ArrayDocument

class SurveyListViewModel : ViewModel() {

    private val _surveyListResult = MutableLiveData<ModelResult<SurveyListModel>>()
    val surveyListResult: LiveData<ModelResult<SurveyListModel>> = _surveyListResult

    fun getSurveyList() {
        // can be launched in a separate asynchronous job
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val result = SurveyApi.instance.getSurveyList(page = 1, size = 10)
                    val list = result as ArrayDocument<SurveyEntity>
                    _surveyListResult.postValue(ModelResult(success = SurveyListModel(list)))
                } catch (e: Exception) {
                    e.printStackTrace()
                    _surveyListResult.postValue(ModelResult(error = 1))
                }
            }
        }

    }

}


package co.nimblehq.sample.ui.surveylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.nimblehq.sample.ui.SurveyUiModel
import co.nimblehq.survey.sdk.entity.SurveyEntity
import kotlinx.coroutines.launch

class SurveyListViewModel : ViewModel() {

    private val _surveyListResult = MutableLiveData<SurveyUiModel<SurveyListModel>>()
    val surveyListResult: LiveData<SurveyUiModel<SurveyListModel>> = _surveyListResult

    fun getSurveyList() {
        // can be launched in a separate asynchronous job
        viewModelScope.launch {
            try {
                //TODO: hardcode for testing, need to be integrate with SDK later
                _surveyListResult.value = SurveyUiModel(success = SurveyListModel(listSurvey = mutableListOf(
                    SurveyEntity("Survey 1", "Description 1"), SurveyEntity("Survey 2", "Description 2")
                )))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}


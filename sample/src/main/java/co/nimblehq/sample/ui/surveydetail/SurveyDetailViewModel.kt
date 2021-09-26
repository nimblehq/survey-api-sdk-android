package co.nimblehq.sample.ui.surveydetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.nimblehq.survey.sdk.entity.SurveyEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SurveyDetailViewModel : ViewModel() {

    private val _surveyDetailResult = MutableLiveData<Result<SurveyEntity>>()
    val surveyDetailResult: LiveData<Result<SurveyEntity>> = _surveyDetailResult

    fun getSurveyDetail() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    // TODO: integration step
                } catch (exception: Exception) {
                }
            }
        }
    }
}

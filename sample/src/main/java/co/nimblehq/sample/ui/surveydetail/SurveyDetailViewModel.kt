package co.nimblehq.sample.ui.surveydetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.nimblehq.sample.ui.ModelResult
import co.nimblehq.surveysdk.SurveyApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SurveyDetailViewModel : ViewModel() {

    private val _surveyDetailResult = MutableLiveData<ModelResult<SurveyDetailModel>>()
    val surveyDetailResult: LiveData<ModelResult<SurveyDetailModel>> = _surveyDetailResult

    fun getSurveyDetail(id: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val result = SurveyApi.getInstance().getSurveyDetail(id = id)
                    _surveyDetailResult.postValue(ModelResult(success = SurveyDetailModel(result)))

                } catch (exception: Exception) {
                    exception.printStackTrace()
                    _surveyDetailResult.postValue(ModelResult(error = 1))
                }
            }
        }
    }

}


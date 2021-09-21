package co.nimblehq.sample.ui.surveylist

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.nimblehq.sample.ui.SurveyUiModel
import co.nimblehq.survey.sdk.model.SurveyModel
import kotlinx.coroutines.launch

class SurveyListViewModel : ViewModel() {

    init {
        getSurveyList()
    }

    private val _surveyListResult = MutableLiveData<SurveyUiModel<List<SurveyModel>>>()
    val surveyListResult: LiveData<SurveyUiModel<List<SurveyModel>>> = _surveyListResult

    fun getSurveyList() {
        // can be launched in a separate asynchronous job
        viewModelScope.launch {
            try {
                //TODO: use postDelayed to simulate calling request from server
                Handler().postDelayed({
                    //TODO: hardcode for testing, need to be integrate with SDK later
                    _surveyListResult.value = SurveyUiModel(
                        success = mutableListOf(
                            SurveyModel("0", "Survey 1", "Description 1"),
                            SurveyModel("1", "Survey 2", "Description 2")
                        )
                    )
                }, 2000)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

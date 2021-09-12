package co.nimblehq.sample.ui.surveylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.nimblehq.sample.ui.ModelResult
import kotlinx.coroutines.launch

class SurveyListViewModel : ViewModel() {


    private val _surveyListResult = MutableLiveData<ModelResult<SurveyListViewModel>>()
    val surveyListResult: LiveData<ModelResult<SurveyListViewModel>> = _surveyListResult

    fun login() {
        // can be launched in a separate asynchronous job
        viewModelScope.launch {
            try {
            } catch (e: Exception) {
            }


        }

    }

}


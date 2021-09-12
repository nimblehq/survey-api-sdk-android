package co.nimblehq.sample.ui.surveylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class SurveyListModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SurveyListViewModel::class.java)) {
            return SurveyListViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

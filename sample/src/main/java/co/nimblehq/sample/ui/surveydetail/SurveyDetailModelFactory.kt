package co.nimblehq.sample.ui.surveydetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class SurveyDetailModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SurveyDetailViewModel::class.java)) {
            return SurveyDetailViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

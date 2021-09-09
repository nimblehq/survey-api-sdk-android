package co.nimblehq.surveysdk.example.ui.screens.home

import androidx.lifecycle.viewModelScope
import co.nimblehq.coroutine.domain.usecase.UseCaseResult
import co.nimblehq.surveysdk.example.ui.base.BaseViewModel
import co.nimblehq.surveysdk.example.ui.base.NavigationEvent
import co.nimblehq.surveysdk.example.ui.screens.second.SecondBundle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

interface Output {


    fun navigateToSecond(bundle: SecondBundle)

}

@HiltViewModel
class HomeViewModel @Inject constructor(
) : BaseViewModel(), Output {


    init {
//        fetchUsers()
    }

    override fun navigateToSecond(bundle: SecondBundle) {
        viewModelScope.launch {
            _navigator.emit(NavigationEvent.Second(bundle))
        }
    }


    private fun fetchUsers() {
        showLoading()
//        viewModelScope.launch {
//            when (val result = getUsersUseCase.execute()) {
//                is UseCaseResult.Success -> _users.value = result.data
//                is UseCaseResult.Error -> _error.emit(result.exception.message.orEmpty())
//            }
//            hideLoading()
//        }
    }
}

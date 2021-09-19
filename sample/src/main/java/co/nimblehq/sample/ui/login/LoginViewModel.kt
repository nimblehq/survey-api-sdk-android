package co.nimblehq.sample.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.nimblehq.sample.AuthService
import co.nimblehq.survey.sdk.SurveyApi
import co.nimblehq.survey.sdk.request.LoginRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel : ViewModel() {
    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(username: String, password: String) {
        // can be launched in a separate asynchronous job
        _loginResult.value =
            LoginResult(success = LoggedInUserView("test", "token"))
    }

}

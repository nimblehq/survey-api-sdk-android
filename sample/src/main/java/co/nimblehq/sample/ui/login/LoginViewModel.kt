package co.nimblehq.sample.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.nimblehq.sample.AuthenService
import co.nimblehq.surveysdk.SurveyApi
import co.nimblehq.surveysdk.request.LoginRequest
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult
    val authenService = SurveyApi.getInstance().buildService<AuthenService>()

    fun login() {
        // can be launched in a separate asynchronous job
        val request = LoginRequest(grantType = "password", email = "dev@nimblehq.co", "12345678")
        viewModelScope.launch {
            try {
                val result = authenService.loginEmail(request)
                SurveyApi.getInstance().setTokenApi(result.data.attributes.accessToken)
                _loginResult.value =
                    LoginResult(success = LoggedInUserView("Hello!"))
            } catch (e: Exception) {
                _loginResult.value = LoginResult(error = 1)
            }


        }

    }

}


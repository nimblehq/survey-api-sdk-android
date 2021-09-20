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

    // As the SDK does not support Authentication service so far, then we will use custom service from the SDK
    val authenService = SurveyApi.instance.buildService<AuthService>()

    fun login() {

        // Hardcoding the credential information because we dont have UI for this one
        val request = LoginRequest(grantType = "password", email = "dev@nimblehq.co", "12345678")
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val result = authenService.loginEmail(request)
                    SurveyApi.instance.setTokenApi(result.data.attributes.accessToken)
                    _loginResult.postValue(LoginResult(success = LoggedInUserView("Hello!")))

                } catch (exception: Exception) {
                    exception.printStackTrace()
                    _loginResult.postValue(LoginResult(error = 1))
                }
            }
        }
    }

}

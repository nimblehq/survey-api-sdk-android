package co.nimblehq.sample.data

import co.nimblehq.sample.data.model.LoggedInUser
import co.nimblehq.survey.sdk.ResultSdk
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): ResultSdk<LoggedInUser> {
        try {
            // TODO: handle loggedInUser authentication
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "Jane Doe")
            return ResultSdk.Success(fakeUser)
        } catch (e: Throwable) {
            return ResultSdk.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}

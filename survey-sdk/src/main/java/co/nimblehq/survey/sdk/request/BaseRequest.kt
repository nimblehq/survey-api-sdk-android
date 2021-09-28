package co.nimblehq.survey.sdk.request

import com.squareup.moshi.Json

abstract class BaseRequest {
    @Json(name = "client_id")
    var clientID: String = credentials.clientID

    @Json(name = "client_secret")
    var clientSecret: String = credentials.clientSecret

    companion object {
        private var credentials = Credentials()

        fun updateAuthenticationInfo(credentialsInfo: Credentials) {
            credentials = credentialsInfo
        }
    }
}

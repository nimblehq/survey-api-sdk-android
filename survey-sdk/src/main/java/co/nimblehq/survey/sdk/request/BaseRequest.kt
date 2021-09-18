package co.nimblehq.survey.sdk.request

import com.squareup.moshi.Json

open class BaseRequest {
    @Json(name = "client_id")
    var clientID: String = clientIdInstance

    @Json(name = "client_secret")
    var clientSecret: String = clientSecretInstance

    companion object {
        private var clientIdInstance = ""
        private var clientSecretInstance = ""

        fun updateAuthenticationInfo(clientId: String, clientSecret: String) {
            clientIdInstance = clientId
            clientSecretInstance = clientSecret
        }
    }
}

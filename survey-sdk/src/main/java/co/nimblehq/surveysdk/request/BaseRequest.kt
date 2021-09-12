package co.nimblehq.surveysdk.request

import com.squareup.moshi.Json


open class BaseRequest {
    @Json(name = "client_id")
    var clientID: String = clientIdInstance

    @Json(name = "client_secret")
    var clientSecret: String = clientSecretInstance


    companion object {
        private var clientIdInstance = ""
        private var clientSecretInstance = ""
        fun updateKey(id: String, secret: String) {
            clientIdInstance = id
            clientSecretInstance = secret
        }
    }
}

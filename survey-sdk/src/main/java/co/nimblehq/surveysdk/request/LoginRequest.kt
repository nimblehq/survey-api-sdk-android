package co.nimblehq.surveysdk.request

import com.squareup.moshi.Json


data class LoginRequest(
    @Json(name = "grant_type")
    val grantType: String,

    val email: String,
    val password: String,

    ) : BaseRequest()

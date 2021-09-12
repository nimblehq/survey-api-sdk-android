package co.nimblehq.sample

import co.nimblehq.sample.entity.TokenEntity
import co.nimblehq.survey.sdk.request.LoginRequest
import moe.banana.jsonapi2.ObjectDocument
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("/api/v1/oauth/token")
    suspend fun loginEmail(@Body request: LoginRequest): ObjectDocument<TokenEntity>

}

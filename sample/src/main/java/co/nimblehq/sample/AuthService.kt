package co.nimblehq.sample

import co.nimblehq.sample.entity.UserEntity
import co.nimblehq.survey.sdk.request.LoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("/api/v1/oauth/token")
    suspend fun loginEmail(@Body request: LoginRequest): UserEntity

}

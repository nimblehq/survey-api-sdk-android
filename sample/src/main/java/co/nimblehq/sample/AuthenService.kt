package co.nimblehq.sample


import co.nimblehq.surveysdk.entity.UserEntity
import co.nimblehq.surveysdk.request.LoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenService {

    @POST("/api/v1/oauth/token")
    suspend fun loginEmail(@Body request: LoginRequest): UserEntity


}

package co.nimblehq.survey.sdk.interceptor

import co.nimblehq.survey.sdk.constant.AUTHORIZATION_HEADER
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class TokenInterceptor constructor(
    private val token: String = "",
    private val tokenType: String = ""
) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val authenticationRequest = request(originalRequest)
        return chain.proceed(authenticationRequest)
    }

    private fun request(originalRequest: Request): Request {
        val builder = originalRequest.newBuilder()
        if (token.isNotEmpty()) {
            builder.addHeader(AUTHORIZATION_HEADER, "$tokenType $token")
        }
        return builder.build()
    }
}

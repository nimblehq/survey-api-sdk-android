package co.nimblehq.survey.sdk.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.io.IOException
import java.util.concurrent.TimeUnit

abstract class NetworkBuilder {
    private var debugMode = false
    private var baseUrl = ""
    private var connectionTimeoutInSecond = 30L
    private var readTimeoutInSecond = 30L
    private var token = ""
    private var tokenType = ""

    fun setDebugMode(debugMode: Boolean): NetworkBuilder {
        this.debugMode = debugMode
        return this
    }

    fun setBaseUrl(url: String): NetworkBuilder {
        this.baseUrl = url
        return this
    }

    fun setConnectionTimeoutInSecond(timeout: Long): NetworkBuilder {
        this.connectionTimeoutInSecond = timeout
        return this
    }

    fun setReadTimeoutInSecond(timeout: Long): NetworkBuilder {
        this.readTimeoutInSecond = timeout
        return this
    }

    fun setToken(token: String): NetworkBuilder {
        this.token = token
        return this
    }

    fun setTokenType(tokenType: String): NetworkBuilder {
        this.tokenType = tokenType
        return this
    }

    fun provideRetrofit(): Retrofit {
        val client: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(connectionTimeoutInSecond, TimeUnit.SECONDS)
            .readTimeout(readTimeoutInSecond, TimeUnit.SECONDS)
            .addInterceptor(TokenInterceptor())
            .addInterceptor(provideLoggingInterceptor()).build()
        return provideRetrofitBuilder()
            .client(client)
            .build()
    }

    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().apply {
            level =
                if (debugMode) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }

    private fun provideRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiBuilderProvider.getJsonApiConverterFactory())
            .addConverterFactory(MoshiBuilderProvider.getConverterFactory())
    }

    inline fun <reified T> buildService(): T {
        return provideRetrofit().create(T::class.java)
    }

    inner class TokenInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest = chain.request()
            val authenticationRequest = request(originalRequest)
            return chain.proceed(authenticationRequest)
        }

        private fun request(originalRequest: Request): Request {
            val builder = originalRequest.newBuilder()
            if (token.isNotEmpty()) {
                builder.addHeader("Authorization", "$tokenType $token")
            }
            return builder.build()
        }
    }
}

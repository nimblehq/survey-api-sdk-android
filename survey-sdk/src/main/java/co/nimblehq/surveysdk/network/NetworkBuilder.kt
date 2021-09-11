package co.nimblehq.surveysdk.network

import co.nimblehq.surveysdk.api.AppService
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

open class NetworkBuilder {
    private var debugMode = false
    private var baseUrl = ""
    private var connectionTimeoutInSecond = 30L
    private var readTimeoutInSecond = 30L

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

    fun provideRetrofit(
    ): Retrofit {
        val client: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(connectionTimeoutInSecond, TimeUnit.SECONDS)
            .readTimeout(readTimeoutInSecond, TimeUnit.SECONDS)
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

    private fun provideRetrofitBuilder(
    ): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(provideMoshi()))
    }

    private fun provideMoshi(): Moshi = MoshiBuilderProvider.moshiBuilder.build()

    protected fun buildAppService(): AppService {
        return provideRetrofit().create(AppService::class.java)
    }

    inline fun <reified T> buildService(): T {
        return provideRetrofit().create(T::class.java)
    }
}

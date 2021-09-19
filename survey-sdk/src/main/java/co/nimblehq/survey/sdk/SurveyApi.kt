package co.nimblehq.survey.sdk

import co.nimblehq.survey.sdk.api.AppService
import co.nimblehq.survey.sdk.entity.SurveyEntity
import co.nimblehq.survey.sdk.network.NetworkBuilder

class SurveyApi private constructor() : NetworkBuilder() {
    private val service: AppService by lazy { buildService() }
    private var version = "v1"
    private var clientId = ""
    private var clientSecret = ""

    companion object {
        val instance: SurveyApi by lazy { SurveyApi() }
    }

    fun withMode(debugMode: Boolean): SurveyApi {
        setDebugMode(debugMode)
        return this
    }

    fun withBaseUrl(url: String): SurveyApi {
        setBaseUrl(url)
        return this
    }

    fun withClientId(clientId: String): SurveyApi {
        this.clientId = clientId
        return this
    }

    fun withClientSecret(clientSecret: String): SurveyApi {
        this.clientSecret = clientSecret
        return this
    }

    fun setTokenApi(token: String): SurveyApi {
        super.setToken(token)
        return this
    }

    fun withConnectionTimeout(timeout: Long): SurveyApi {
        setConnectionTimeoutInSecond(timeout)
        return this
    }

    fun withReadTimeout(timeout: Long): SurveyApi {
        setReadTimeoutInSecond(timeout)
        return this
    }

    fun withVersion(version: String): SurveyApi {
        this.version = version
        return this
    }

    //Below are public apis

    suspend fun getSurveyList(page: Int, size: Int): ResultSdk<List<SurveyEntity>> {
        return try {
            val result = service.getSurveyList(page, size, version)
            ResultSdk.Success(result)

        } catch (exception: Exception) {
            exception.printStackTrace()
            ResultSdk.Error(exception)
        }
    }

    suspend fun getSurveyDetail(id: String): ResultSdk<SurveyEntity> {
        return try {
            val result = service.getSurveyDetail(id, version)
            ResultSdk.Success(result.get())

        } catch (exception: Exception) {
            exception.printStackTrace()
            ResultSdk.Error(exception)
        }
    }

}

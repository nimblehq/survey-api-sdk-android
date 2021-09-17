package co.nimblehq.survey.sdk

import co.nimblehq.survey.sdk.api.AppService
import co.nimblehq.survey.sdk.entity.SurveyEntity
import co.nimblehq.survey.sdk.network.NetworkBuilder
import moe.banana.jsonapi2.ArrayDocument
import moe.banana.jsonapi2.ObjectDocument

class SurveyApi : NetworkBuilder() {
    private lateinit var service: AppService
    private var version = "v1"

    companion object {
        private lateinit var instancce: SurveyApi
        fun getInstance(): SurveyApi = instancce

        fun setup(): SurveyApi {
            instancce = SurveyApi()
            return instancce
        }
    }

    fun withMode(debugMode: Boolean): SurveyApi {
        setDebugMode(debugMode)
        return this
    }

    fun withBaseUrl(url: String): SurveyApi {
        setBaseUrl(url)
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

    //IMPORTANT : need to be called after the configuration
    fun build() {
        service = buildService()
    }

    //public api
    suspend fun getSurveyList(page: Int, size: Int): ArrayDocument<SurveyEntity> {
        return service.getSurveyList(page, size, version)
    }

    suspend fun getSurveyDetail(id: String): ObjectDocument<SurveyEntity> {
        return service.getSurveyDetail(id, version)
    }

}

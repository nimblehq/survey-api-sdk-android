package co.nimblehq.survey.sdk

import co.nimblehq.survey.sdk.api.AppService
import co.nimblehq.survey.sdk.entity.toSurveyModel
import co.nimblehq.survey.sdk.model.SurveyModel
import co.nimblehq.survey.sdk.network.MoshiBuilderProvider
import co.nimblehq.survey.sdk.network.NetworkBuilder
import co.nimblehq.survey.sdk.request.BaseRequest
import co.nimblehq.survey.sdk.request.Credentials
import kotlinx.coroutines.*
import moe.banana.jsonapi2.Resource

class SurveyApi private constructor() : NetworkBuilder() {
    private val service: AppService by lazy { buildService() }
    private var version = "v1"

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

    fun withCredentials(credentials: Credentials) {
        BaseRequest.updateAuthenticationInfo(credentials)
    }

    fun setTokenKey(token: String): SurveyApi {
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

    // TODO: need to make a decision if the Sdk really need to support outside JsonApi Resource
    fun addJsonApiClasses(vararg classes: Class<out Resource>): SurveyApi {
        MoshiBuilderProvider.addJsonApiClasses(*classes)
        return this
    }

    /**
     * Return the list of Surveys. The request is asynchronously done in the background.
     *
     * params: [page] the page number which want to fetch.
     * params: [size] size of page.
     * params: [onResponse] is a callback when the data is fetched.
     */
    @DelicateCoroutinesApi
    fun getSurveyList(page: Int, size: Int, onResponse: (Result<List<SurveyModel>>) -> Unit) {
        // TODO: need to look back the way for data manipulation
        GlobalScope.launch(Dispatchers.IO) {
            val result = try {
                val result = service.getSurveyList(version, page, size)
                Result.Success(result.map { item -> item.toSurveyModel() })
            } catch (exception: Exception) {
                exception.printStackTrace()
                Result.Error(exception)
            }
            withContext(Dispatchers.Main) {
                onResponse(result)
            }
        }
    }

    /**
     * Return the detail of Survey. The request is asynchronously done in the background.
     *
     * params: [surveyId] id of Survey which want to fetch detail.
     * params: [onResponse] is a callback when the data is fetched.
     */
    @DelicateCoroutinesApi
    fun getSurveyDetail(surveyId: String, onResponse: (Result<SurveyModel>) -> Unit) {
        // TODO: need to look back the way for data manipulation
        GlobalScope.launch(Dispatchers.IO) {
            val result = try {
                val result = service.getSurveyDetail(surveyId, version)
                Result.Success(result.toSurveyModel())
            } catch (exception: Exception) {
                exception.printStackTrace()
                Result.Error(exception)
            }
            withContext(Dispatchers.Main) {
                onResponse(result)
            }
        }
    }
}

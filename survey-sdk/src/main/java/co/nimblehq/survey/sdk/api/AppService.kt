package co.nimblehq.survey.sdk.api

import co.nimblehq.survey.sdk.entity.SurveyEntity
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AppService {

    @GET("/api/{version}/surveys")
    suspend fun getSurveyList(
        @Path("version") version: String = "v1",
        @Query("page[number]") page: Int,
        @Query("page[size]") size: Int
    ): List<SurveyEntity>

    @GET("/api/{version}/surveys/{id}")
    suspend fun getSurveyDetail(
        @Path("id") id: String,
        @Path("version") version: String = "v1"
    ): SurveyEntity

}

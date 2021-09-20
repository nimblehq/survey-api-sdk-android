package co.nimblehq.survey.sdk.api

import co.nimblehq.survey.sdk.entity.SurveyEntity
import moe.banana.jsonapi2.ArrayDocument
import moe.banana.jsonapi2.ObjectDocument
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AppService {

    @GET("/api/{version}/surveys")
    suspend fun getSurveyList(
        @Path("version") version: String = "v1",
        @Query("page[number]") page: Int,
        @Query("page[size]") size: Int
    ): ArrayDocument<SurveyEntity>

    @GET("/api/{version}/surveys/{id}")
    suspend fun getSurveyDetail(
        @Path("id") id: String,
        @Path("version") version: String = "v1"
    ): ObjectDocument<SurveyEntity>

}

package co.nimblehq.surveysdk.api


import co.nimblehq.surveysdk.entity.SurveyDetailEntity
import co.nimblehq.surveysdk.entity.SurveyListEntity
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AppService {

    @GET("/api/{version}/surveys")
    suspend fun getSurveyList(
        @Query("page[number]") page: Int,
        @Query("page[size]") size: Int,
        @Path("version") version: String = "v1",
    ): SurveyListEntity

    @GET("/api/{version}/surveys/{id}")
    suspend fun getSurveyDetail(
        @Path("id") id: String,
        @Path("version") version: String = "v1",
    ): SurveyDetailEntity

}

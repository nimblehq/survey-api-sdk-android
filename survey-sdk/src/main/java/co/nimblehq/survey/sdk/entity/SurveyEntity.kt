package co.nimblehq.survey.sdk.entity

import com.squareup.moshi.Json
import moe.banana.jsonapi2.HasMany
import moe.banana.jsonapi2.JsonApi
import moe.banana.jsonapi2.Resource

@JsonApi(type = "survey")
class SurveyEntity : Resource() {
    var title: String? = ""
    var description: String = ""

    @field:Json(name = "thank_email_above_threshold")
    var thankEmailAboveThreshold: String = ""

    @field:Json(name = "thank_email_below_threshold")
    var thankEmailBelowThreshold: String? = ""

    @field:Json(name = "is_active")
    var isActive: Boolean? = false

    @field:Json(name = "cover_image_url")
    var coverImageURL: String? = ""

    @field:Json(name = "created_at")
    var createdAt: String? = ""

    @field:Json(name = "active_at")
    var activeAt: String? = ""

    @field:Json(name = "survey_type")
    var surveyType: String? = ""

    var questions: HasMany<QuestionEntity>? = null

    fun getQuestionList(): List<QuestionEntity>? {
        val resources = questions?.get()
        return resources?.map { resource ->
            QuestionEntity().apply {
                id = resource.id
                type = resource.type
            }
        }
    }

}

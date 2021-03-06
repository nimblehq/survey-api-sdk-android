package co.nimblehq.survey.sdk.entity

import co.nimblehq.survey.sdk.model.SurveyModel
import com.squareup.moshi.Json
import moe.banana.jsonapi2.HasMany
import moe.banana.jsonapi2.JsonApi
import moe.banana.jsonapi2.Resource

@JsonApi(type = "survey")
data class SurveyEntity(
    @field:Json(name = "title")
    var title: String? = null,

    @field:Json(name = "description")
    var description: String? = null,

    @field:Json(name = "thank_email_above_threshold")
    var thankEmailAboveThreshold: String? = null,

    @field:Json(name = "thank_email_below_threshold")
    var thankEmailBelowThreshold: String? = null,

    @field:Json(name = "is_active")
    var isActive: Boolean? = null,

    @field:Json(name = "cover_image_url")
    var coverImageURL: String? = null,

    @field:Json(name = "created_at")
    var createdAt: String? = null,

    @field:Json(name = "active_at")
    var activeAt: String? = null,

    @field:Json(name = "survey_type")
    var surveyType: String? = null,

    var questions: HasMany<QuestionEntity>? = null

) : Resource() {
    val questionList: List<QuestionEntity>?
        get() = questions?.get(document)
}

fun SurveyEntity.toSurveyModel(): SurveyModel {
    return SurveyModel(
        surveyId = id,
        surveyTitle = title.orEmpty(),
        surveyDescription = description.orEmpty()
    )
}

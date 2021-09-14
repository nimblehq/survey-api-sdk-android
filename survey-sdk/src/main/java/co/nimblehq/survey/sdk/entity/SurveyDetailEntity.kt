package co.nimblehq.survey.sdk.entity

import com.squareup.moshi.Json

data class SurveyDetailEntity(
    val data: SurveyItem,
    val included: List<SurveyItem>?
) {

    data class SurveyItem(
        var id: String,
        var type: String?,
        var attributes: Attributes?,
        var relationships: Relationships?
    ) {
        data class Attributes(
            var title: String?,
            var description: String?,

            @Json(name = "thank_email_above_threshold")
            var thankEmailAboveThreshold: String?,

            @Json(name = "thank_email_below_threshold")
            var thankEmailBelowThreshold: String?,

            @Json(name = "is_active")
            var isActive: Boolean?,

            @Json(name = "cover_image_url")
            var coverImageURL: String?,

            @Json(name = "created_at")
            var createdAt: String?,

            @Json(name = "active_at")
            var activeAt: String?,


            @Json(name = "survey_type")
            var surveyType: String?
        )

        data class Relationships(
            val questions: Questions?
        ) {
            data class Questions(
                val data: List<QuestionsDatum>?
            ) {
                data class QuestionsDatum(
                    val id: String,
                    val type: String
                )
            }
        }
    }

}

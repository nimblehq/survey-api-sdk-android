package co.nimblehq.survey.sdk.entity

import com.squareup.moshi.Json
import moe.banana.jsonapi2.HasMany
import moe.banana.jsonapi2.JsonApi
import moe.banana.jsonapi2.Resource

@JsonApi(type = "question")
data class QuestionEntity(
    @field:Json(name = "text")
    var text: String? = null,

    @field:Json(name = "help_text")
    var helpText: String? = null,

    @field:Json(name = "display_order")
    var displayOrder: Int = 0,

    @field:Json(name = "short_text")
    var shortText: String? = null,

    @field:Json(name = "pick")
    var pick: String? = null,

    @field:Json(name = "display_type")
    var displayType: String? = null,

    @field:Json(name = "is_mandatory")
    var isMandatory: Boolean? = null,

    @field:Json(name = "image_url")
    var imageUrl: String? = null,

    @field:Json(name = "cover_image_url")
    var coverImageUrl: String? = null,

    @field:Json(name = "cover_image_opacity")
    var coverImageOpacity: Double? = null,

    @field:Json(name = "is_shareable_on_facebook")
    var isShareableOnFacebook: Boolean? = null,

    @field:Json(name = "is_shareable_on_twitter")
    var isShareableOnTwitter: Boolean? = null,

    @field:Json(name = "tag_list")
    var tagList: String? = null,

    var answers: HasMany<AnswerEntity>? = null

) : Resource() {
    fun getAnswerList(): List<AnswerEntity>? = answers?.get(document)
}

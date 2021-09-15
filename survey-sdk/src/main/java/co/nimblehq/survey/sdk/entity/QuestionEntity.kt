package co.nimblehq.survey.sdk.entity

import com.squareup.moshi.Json
import moe.banana.jsonapi2.HasMany
import moe.banana.jsonapi2.JsonApi
import moe.banana.jsonapi2.Resource

@JsonApi(type = "question")
open class QuestionEntity : Resource() {
    var text: String? = ""

    @field:Json(name = "help_text")
    var helpText: String? = ""

    @field:Json(name = "display_order")
    var displayOrder = 0

    @field:Json(name = "short_text")
    var shortText: String? = ""

    var pick: String? = ""

    @field:Json(name = "display_type")
    var displayType: String? = ""

    @field:Json(name = "is_mandatory")
    var isMandatory: Boolean? = false

    @field:Json(name = "image_url")
    var imageUrl: String? = ""

    @field:Json(name = "cover_image_url")
    var coverImageUrl: String? = ""

    @field:Json(name = "cover_image_opacity")
    var coverImageOpacity: Double? = 0.0

    @field:Json(name = "is_shareable_on_facebook")
    var isShareableOnFacebook: Boolean? = false

    @field:Json(name = "is_shareable_on_twitter")
    var isShareableOnTwitter: Boolean? = false

    @field:Json(name = "tag_list")
    var tagList: String? = ""

    var answers: HasMany<AnswerEntity>? = null

    fun getAnswerList(): List<AnswerEntity>? {
        val resources = answers?.get()
        return resources?.map { resource ->
            AnswerEntity().apply {
                id = resource.id
                type = resource.type
            }
        }
    }
}

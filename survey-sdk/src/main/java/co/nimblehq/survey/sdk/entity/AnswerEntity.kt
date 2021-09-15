package co.nimblehq.survey.sdk.entity

import com.squareup.moshi.Json
import moe.banana.jsonapi2.JsonApi

@JsonApi(type = "answer")
class AnswerEntity : QuestionEntity() {
    @field:Json(name = "input_mask_placeholder")
    var inputMaskPlaceholder: String? = null

    @field:Json(name = "is_customer_first_name")
    var isCustomerFirstName: Boolean? = null

    @field:Json(name = "is_customer_last_name")
    var isCustomerLastName: Boolean? = null

    @field:Json(name = "is_customer_title")
    var isCustomerTitle: Boolean? = null

    @field:Json(name = "is_customer_email")
    var isCustomerEmail: Boolean? = null

    @field:Json(name = "prompt_custom_answer")
    var promptCustomAnswer: Boolean? = null

    @field:Json(name = "input_mask")
    var inputMask: String? = null

    @field:Json(name = "response_class")
    var responseClass: String? = null

}

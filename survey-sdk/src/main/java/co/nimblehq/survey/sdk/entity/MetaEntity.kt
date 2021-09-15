package co.nimblehq.survey.sdk.entity

import com.squareup.moshi.Json

data class MetaEntity(
    val page: Int,
    val pages: Int,

    @Json(name = "page_size")
    val pageSize: Int,

    val records: Int
)

package co.nimblehq.survey.sdk.entity

import com.squareup.moshi.Json

data class MetaEntity(
    @Json(name = "page")
    val page: Int,

    @Json(name = "pages")
    val pages: Int,

    @Json(name = "page_size")
    val pageSize: Int,

    @Json(name = "records")
    val records: Int
)

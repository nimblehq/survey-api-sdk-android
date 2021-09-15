package co.nimblehq.survey.sdk.entity

import com.squareup.moshi.Json

data class MetaEntity(
    @Json(name = "page")
    val page: Int? = null,

    @Json(name = "pages")
    val pages: Int? = null,

    @Json(name = "page_size")
    val pageSize: Int? = null,

    @Json(name = "records")
    val records: Int? = null
)

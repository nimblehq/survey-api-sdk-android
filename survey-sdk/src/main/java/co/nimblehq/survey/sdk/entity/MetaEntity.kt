package co.nimblehq.survey.sdk.entity

import com.squareup.moshi.Json

/*
This class not be included into json-api.
Hence, we use @Json annotation for Parsing with Moshi Adapter
 */
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

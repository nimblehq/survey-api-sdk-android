package co.nimblehq.sample.entity

import com.squareup.moshi.Json
import moe.banana.jsonapi2.JsonApi
import moe.banana.jsonapi2.Resource

@JsonApi(type = "token")
data class TokenEntity(
    @field:Json(name = "access_token")
    val accessToken: String? = null,

    @field:Json(name = "token_type")
    val tokenType: String? = null,

    @field:Json(name = "expires_in")
    val expiresIn: Long? = null,

    @field:Json(name = "refresh_token")
    val refreshToken: String? = null,

    @field:Json(name = "created_at")
    val createdAt: Long? = null
) : Resource()

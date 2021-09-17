package co.nimblehq.sample.entity

import com.squareup.moshi.Json

data class UserEntity(
    @Json(name = "data")
    var data: Data
) {
    data class Data(
        @Json(name = "id")
        val id: Long,

        @Json(name = "type")
        val type: String,

        @Json(name = "attributes")
        val attributes: Attributes
    ) {
        data class Attributes(
            @Json(name = "access_token")
            val accessToken: String,

            @Json(name = "token_type")
            val tokenType: String,

            @Json(name = "expires_in")
            val expiresIn: Long,

            @Json(name = "refresh_token")
            val refreshToken: String,

            @Json(name = "created_at")
            val createdAt: Long
        )
    }

}

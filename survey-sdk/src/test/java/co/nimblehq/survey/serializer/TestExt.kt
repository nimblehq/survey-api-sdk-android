package co.nimblehq.survey.serializer

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

inline fun <reified T> String.toJsonObject(): T? {
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    val jsonAdapter: JsonAdapter<T> = moshi.adapter(T::class.java)
    return jsonAdapter.fromJson(this)
}

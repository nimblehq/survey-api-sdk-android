package co.nimblehq.survey.sdk.network

import co.nimblehq.survey.sdk.entity.AnswerEntity
import co.nimblehq.survey.sdk.entity.QuestionEntity
import co.nimblehq.survey.sdk.entity.SurveyEntity
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import moe.banana.jsonapi2.JsonApiConverterFactory
import moe.banana.jsonapi2.ResourceAdapterFactory
import retrofit2.Converter
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*

object MoshiBuilderProvider {

    enum class ConverterType {
        JSONAPI, JSON
    }

    private val moshiBuilder: Moshi.Builder
        get() = Moshi.Builder()
            .add(Date::class.java, Rfc3339DateJsonAdapter())
            .add(KotlinJsonAdapterFactory())

    private fun provideJsonApiFactory() : JsonAdapter.Factory = ResourceAdapterFactory.builder()
        .add(SurveyEntity::class.java)
        .add(QuestionEntity::class.java)
        .add(AnswerEntity::class.java)
        .build()

    private fun provideJsonApiMoshi(): Moshi = moshiBuilder.add((provideJsonApiFactory())).build()

    private fun getJsonApiConverterFactory() : JsonApiConverterFactory = JsonApiConverterFactory.create(provideJsonApiMoshi())

    private fun getConverterFactory(): MoshiConverterFactory = MoshiConverterFactory.create(moshiBuilder.build())

    fun provide (type : ConverterType) : Converter.Factory {
        return when(type)  {
            ConverterType.JSONAPI -> getJsonApiConverterFactory()
            else -> getConverterFactory()
        }
    }
}

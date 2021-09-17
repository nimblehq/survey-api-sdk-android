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
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*

object MoshiBuilderProvider {

    private val moshiBuilder: Moshi.Builder
        get() = Moshi.Builder()
            .add(Date::class.java, Rfc3339DateJsonAdapter())
            .add(KotlinJsonAdapterFactory())

    private fun provideJsonApiFactory() : JsonAdapter.Factory = ResourceAdapterFactory.builder()
        .add(SurveyEntity::class.java)
        .add(QuestionEntity::class.java)
        .add(AnswerEntity::class.java)
        .build()

    private fun provideMoshi(): Moshi = moshiBuilder.add((provideJsonApiFactory())).build()

    fun getJsonApiConverterFactory() : JsonApiConverterFactory = JsonApiConverterFactory.create(provideMoshi())

    fun getConverterFactory(): MoshiConverterFactory = MoshiConverterFactory.create(moshiBuilder.build())
}

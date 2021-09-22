package co.nimblehq.survey.sdk.network

import co.nimblehq.survey.sdk.entity.AnswerEntity
import co.nimblehq.survey.sdk.entity.QuestionEntity
import co.nimblehq.survey.sdk.entity.SurveyEntity
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import moe.banana.jsonapi2.JsonApiConverterFactory
import moe.banana.jsonapi2.ResourceAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object MoshiBuilderProvider {

    fun provideJsonApiFactory(): JsonAdapter.Factory = ResourceAdapterFactory.builder()
        .add(SurveyEntity::class.java)
        .add(QuestionEntity::class.java)
        .add(AnswerEntity::class.java)
        .build()

    fun provideJsonApiMoshi(moshiBuilder: Moshi.Builder, factory: JsonAdapter.Factory): Moshi =
        moshiBuilder.add((factory)).build()

    fun getJsonApiConverterFactory(moshi: Moshi): JsonApiConverterFactory =
        JsonApiConverterFactory.create(moshi)

    fun getConverterFactory(moshiBuilder: Moshi.Builder): MoshiConverterFactory =
        MoshiConverterFactory.create(moshiBuilder.add(KotlinJsonAdapterFactory()).build())

}

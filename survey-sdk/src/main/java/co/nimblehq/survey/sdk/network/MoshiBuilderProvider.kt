package co.nimblehq.survey.sdk.network

import co.nimblehq.survey.sdk.entity.AnswerEntity
import co.nimblehq.survey.sdk.entity.QuestionEntity
import co.nimblehq.survey.sdk.entity.SurveyEntity
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import moe.banana.jsonapi2.JsonApiConverterFactory
import moe.banana.jsonapi2.Resource
import moe.banana.jsonapi2.ResourceAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object MoshiBuilderProvider {

    private val listJsonApiClass = mutableListOf<Class<out Resource>>(
        SurveyEntity::class.java,
        QuestionEntity::class.java,
        AnswerEntity::class.java
    )

    private val moshiBuilder: Moshi.Builder
        get() = Moshi.Builder()

    private fun provideJsonApiFactory(): JsonAdapter.Factory = ResourceAdapterFactory.builder()
        .add(*listJsonApiClass.toTypedArray())
        .build()

    private fun provideMoshi(): Moshi = moshiBuilder
        .add((provideJsonApiFactory())).build()

    fun getJsonApiConverterFactory(): JsonApiConverterFactory =
        JsonApiConverterFactory.create(provideMoshi())

    fun addJsonApiClasses(vararg classes: Class<out Resource>) {
        listJsonApiClass.addAll(classes)
    }

    fun getConverterFactory(): MoshiConverterFactory = MoshiConverterFactory.create(
        moshiBuilder.add(
            KotlinJsonAdapterFactory()
        ).build()
    )
}

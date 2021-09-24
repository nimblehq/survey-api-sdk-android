package co.nimblehq.survey.sdk.network

import co.nimblehq.survey.sdk.entity.AnswerEntity
import co.nimblehq.survey.sdk.entity.QuestionEntity
import co.nimblehq.survey.sdk.entity.SurveyEntity
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

    fun provideJsonApiFactory(): ResourceAdapterFactory = ResourceAdapterFactory.builder()
        .add(*listJsonApiClass.toTypedArray())
        .build()

    fun provideMoshiJsonApi(
        jsonApiFactory: ResourceAdapterFactory,
        moshiBuilder: Moshi.Builder
    ): Moshi = moshiBuilder
        .add((jsonApiFactory)).build()

    fun getJsonApiConverterFactory(moshiJsonApi: Moshi): JsonApiConverterFactory =
        JsonApiConverterFactory.create(moshiJsonApi)

    // TODO: need to make a decision if the Sdk really need to support outside JsonApi Resource
    fun addJsonApiClasses(vararg classes: Class<out Resource>) {
        listJsonApiClass.addAll(classes)
    }

    fun getConverterFactory(moshiBuilder: Moshi.Builder): MoshiConverterFactory =
        MoshiConverterFactory.create(
            moshiBuilder.add(
                KotlinJsonAdapterFactory()
            ).build()
        )
}

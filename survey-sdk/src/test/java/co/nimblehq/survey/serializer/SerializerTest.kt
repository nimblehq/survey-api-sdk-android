package co.nimblehq.survey.serializer

import co.nimblehq.survey.sdk.entity.AnswerEntity
import co.nimblehq.survey.sdk.entity.MetaEntity
import co.nimblehq.survey.sdk.entity.QuestionEntity
import co.nimblehq.survey.sdk.entity.SurveyEntity
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import moe.banana.jsonapi2.ArrayDocument
import moe.banana.jsonapi2.Document
import moe.banana.jsonapi2.ObjectDocument
import moe.banana.jsonapi2.ResourceAdapterFactory
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SerializerTest {
    lateinit var moshi: Moshi

    @Before
    fun setup() {
        val jsonApiAdapterFactory: JsonAdapter.Factory = ResourceAdapterFactory.builder()
            .add(SurveyEntity::class.java)
            .add(QuestionEntity::class.java)
            .add(AnswerEntity::class.java)
            .build()
        moshi = Moshi.Builder()
            .add(jsonApiAdapterFactory) // ...
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Test
    fun `when parsing the right json string as list survey, it should return the SurveyListEntity`() {

        val surveyList: ArrayDocument<SurveyEntity> =
            moshi.adapter(Document::class.java)
                .fromJson(JSON_SURVEY_LIST_TEST) as ArrayDocument<SurveyEntity>
        assertTrue(surveyList.isNotEmpty())
        //item test

        val firstItem = surveyList.first()
        //attributes test
        assertTrue(firstItem.title == "Scarlett Bangkok")
        assertTrue(firstItem.description == "We'd love ot hear from you!")
        assertTrue(firstItem.thankEmailAboveThreshold == "Test1")
        assertTrue(firstItem.thankEmailBelowThreshold == "Test2")
        assertTrue(firstItem.isActive == true)
        assertTrue(firstItem.coverImageURL == "https://dhdbhh0jsld0o.cloudfront.net/m/1ea51560991bcb7d00d0_")
        assertTrue(firstItem.createdAt == "2017-01-23T07:48:12.991Z")
        assertTrue(firstItem.activeAt == "2015-10-08T07:04:00.000Z")
        assertTrue(firstItem.surveyType == "Restaurant")

        //relationship test
        assertNotNull(firstItem.questions)
        val questionList = firstItem.getQuestionList()
        assertTrue(questionList?.isNotEmpty() == true)
        //first data test
        val firstData = questionList?.first()
        assertTrue(firstData?.id == "d3afbcf2b1d60af845dc")
        assertTrue(firstData?.type == "question")

        val metaJsonBuffer = surveyList.meta
        //meta test
        assertNotNull(metaJsonBuffer)
        val meta =
            metaJsonBuffer.get<MetaEntity>(moshi.adapter(MetaEntity::class.java)) as? MetaEntity
        assertNotNull(meta)
        assertTrue(meta?.page == 1)
        assertTrue(meta?.pages == 10)
        assertTrue(meta?.pageSize == 2)
        assertTrue(meta?.records == 20)
    }

    @Test
    fun `when parsing the right json string as survey detail, it should return the SurveyEntity`() {
        val surveyDocument: ObjectDocument<SurveyEntity> =
            moshi.adapter(Document::class.java)
                .fromJson(JSON_SURVEY_DETAIL_TEST) as ObjectDocument<SurveyEntity>

        assertNotNull(surveyDocument)
        //item test
        val surveyDetail = surveyDocument.get()
        //attributes test
        assertTrue(surveyDetail.title == "Scarlett Bangkok")
        assertTrue(surveyDetail.description == "We'd love ot hear from you!")
        assertTrue(surveyDetail.thankEmailAboveThreshold == "Test1")
        assertTrue(surveyDetail.thankEmailBelowThreshold == "Test2")
        assertTrue(surveyDetail.isActive == true)
        assertTrue(surveyDetail.coverImageURL == "https://dhdbhh0jsld0o.cloudfront.net/m/1ea51560991bcb7d00d0_")
        assertTrue(surveyDetail.createdAt == "2017-01-23T07:48:12.991Z")
        assertTrue(surveyDetail.activeAt == "2015-10-08T07:04:00.000Z")
        assertTrue(surveyDetail.surveyType == "Restaurant")

        //relationship test
        assertNotNull(surveyDetail.questions)
        val questionList = surveyDetail.getQuestionList()
        assertTrue(questionList?.isNotEmpty() == true)
        //first data test
        val firstData = questionList?.first()
        assertTrue(firstData?.id == "d3afbcf2b1d60af845dc")
        assertTrue(firstData?.type == "question")
        //included test
        val included = surveyDocument.included
        assertNotNull(included)
        assertTrue(included.isNotEmpty())
        //question type test
        val questionType = included.first() as QuestionEntity
        assertTrue(questionType.id == "d3afbcf2b1d60af845dc")
        assertTrue(questionType.type == "question")
        assertTrue(questionType.text?.contains("Thank you for visiting Scarlett!") == true)
        assertTrue(questionType.helpText == null)
        assertTrue(questionType.displayOrder == 0)
        assertTrue(questionType.shortText == "introduction")
        assertTrue(questionType.pick == "none")
        assertTrue(questionType.displayType == "intro")
        assertTrue(questionType.isMandatory == false)
        assertTrue(questionType.imageUrl == "https://dhdbhh0jsld0o.cloudfront.net/m/2001ebbfdcbf6c00c757_")
        assertTrue(questionType.coverImageUrl == "https://dhdbhh0jsld0o.cloudfront.net/m/1ea51560991bcb7d00d0_")
        assertTrue(questionType.coverImageOpacity == 0.6)
        assertTrue(questionType.isShareableOnFacebook == false)
        assertTrue(questionType.isShareableOnTwitter == false)
        assertTrue(questionType.tagList?.isEmpty() == true)
        assertTrue(questionType.answers != null)
        //answer type test
        val answerType = included.last() as AnswerEntity
        assertTrue(answerType.id == "575db8c074601994bde3")
        assertTrue(answerType.type == "answer")
        assertTrue(answerType.text?.contains("Email") == true)
        assertTrue(answerType.helpText == null)
        assertTrue(answerType.inputMaskPlaceholder == "you@example.com")
        assertTrue(answerType.shortText == "answer_6")
        assertTrue(answerType.isMandatory == false)
        assertTrue(answerType.isCustomerFirstName == false)
        assertTrue(answerType.isCustomerLastName == false)
        assertTrue(answerType.isCustomerTitle == false)
        assertTrue(answerType.isCustomerEmail == true)
        assertTrue(answerType.promptCustomAnswer == false)
        assertTrue(answerType.displayOrder == 2)
        assertTrue(answerType.displayType == "default")
        assertTrue(answerType.inputMask == "[\\.\\-_\\+a-zA-Z0-9]+@[\\-\\a-zA-Z0-9]+(?:\\.[\\-a-zA-Z0-9]+)+")
        assertTrue(answerType.responseClass == "string")
    }

}

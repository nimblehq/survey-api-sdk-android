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
    private lateinit var moshi: Moshi

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
        //Item test

        val firstItem = surveyList.first()
        // Attributes test
        with(firstItem) {
            assertTrue(title == "Scarlett Bangkok")
            assertTrue(description == "We'd love ot hear from you!")
            assertTrue(thankEmailAboveThreshold == "Test1")
            assertTrue(thankEmailBelowThreshold == "Test2")
            assertTrue(isActive == true)
            assertTrue(coverImageURL == "https://dhdbhh0jsld0o.cloudfront.net/m/1ea51560991bcb7d00d0_")
            assertTrue(createdAt == "2017-01-23T07:48:12.991Z")
            assertTrue(activeAt == "2015-10-08T07:04:00.000Z")
            assertTrue(surveyType == "Restaurant")
        }

        // Relationship test
        assertNotNull(firstItem.questions)
        val questionList = firstItem.getQuestionList()
        assertTrue(questionList?.isNotEmpty() == true)

        // First data test
        val firstData = questionList?.first()
        assertNotNull(firstData)
        firstData?.run {
            assertTrue(id == "d3afbcf2b1d60af845dc")
            assertTrue(type == "question")
        }

        // Meta test
        val metaJsonBuffer = surveyList.meta
        assertNotNull(metaJsonBuffer)
        val meta =
            metaJsonBuffer.get<MetaEntity>(moshi.adapter(MetaEntity::class.java)) as? MetaEntity
        assertNotNull(meta)
        meta?.run {
            assertTrue(page == 1)
            assertTrue(pages == 10)
            assertTrue(pageSize == 2)
            assertTrue(records == 20)
        }

    }

    @Test
    fun `when parsing the right json string as survey detail, it should return the SurveyEntity`() {
        val surveyDocument: ObjectDocument<SurveyEntity> =
            moshi.adapter(Document::class.java)
                .fromJson(JSON_SURVEY_DETAIL_TEST) as ObjectDocument<SurveyEntity>

        assertNotNull(surveyDocument)

        // Item test
        val surveyDetail = surveyDocument.get()

        // Attributes test
        with(surveyDetail) {
            assertTrue(title == "Scarlett Bangkok")
            assertTrue(description == "We'd love ot hear from you!")
            assertTrue(thankEmailAboveThreshold == "Test1")
            assertTrue(thankEmailBelowThreshold == "Test2")
            assertTrue(isActive == true)
            assertTrue(coverImageURL == "https://dhdbhh0jsld0o.cloudfront.net/m/1ea51560991bcb7d00d0_")
            assertTrue(createdAt == "2017-01-23T07:48:12.991Z")
            assertTrue(activeAt == "2015-10-08T07:04:00.000Z")
            assertTrue(surveyType == "Restaurant")
        }


        // Relationship test
        assertNotNull(surveyDetail.questions)
        val questionList = surveyDetail.getQuestionList()
        assertTrue(questionList?.isNotEmpty() == true)

        // First data test
        val firstData = questionList?.first()
        assertNotNull(firstData)
        firstData?.run {
            assertTrue(id == "d3afbcf2b1d60af845dc")
            assertTrue(type == "question")
        }


        // Included test
        val included = surveyDocument.included
        assertNotNull(included)
        assertTrue(included.isNotEmpty())

        // Question type test
        val questionType = included.first() as QuestionEntity
        with(questionType) {
            assertTrue(id == "d3afbcf2b1d60af845dc")
            assertTrue(type == "question")
            assertTrue(text?.contains("Thank you for visiting Scarlett!") == true)
            assertTrue(helpText == null)
            assertTrue(displayOrder == 0)
            assertTrue(shortText == "introduction")
            assertTrue(pick == "none")
            assertTrue(displayType == "intro")
            assertTrue(isMandatory == false)
            assertTrue(imageUrl == "https://dhdbhh0jsld0o.cloudfront.net/m/2001ebbfdcbf6c00c757_")
            assertTrue(coverImageUrl == "https://dhdbhh0jsld0o.cloudfront.net/m/1ea51560991bcb7d00d0_")
            assertTrue(coverImageOpacity == 0.6)
            assertTrue(isShareableOnFacebook == false)
            assertTrue(isShareableOnTwitter == false)
            assertTrue(tagList?.isEmpty() == true)
            assertTrue(answers != null)
        }

        // Answer type test
        val answerType = included.last() as AnswerEntity
        with(answerType) {
            assertTrue(id == "575db8c074601994bde3")
            assertTrue(type == "answer")
            assertTrue(text?.contains("Email") == true)
            assertTrue(helpText == null)
            assertTrue(inputMaskPlaceholder == "you@example.com")
            assertTrue(shortText == "answer_6")
            assertTrue(isMandatory == false)
            assertTrue(isCustomerFirstName == false)
            assertTrue(isCustomerLastName == false)
            assertTrue(isCustomerTitle == false)
            assertTrue(isCustomerEmail == true)
            assertTrue(promptCustomAnswer == false)
            assertTrue(displayOrder == 2)
            assertTrue(displayType == "default")
            assertTrue(inputMask == "[\\.\\-_\\+a-zA-Z0-9]+@[\\-\\a-zA-Z0-9]+(?:\\.[\\-a-zA-Z0-9]+)+")
            assertTrue(responseClass == "string")
        }
    }

}

package co.nimblehq.survey.serializer


import co.nimblehq.survey.sdk.entity.SurveyDetailEntity
import co.nimblehq.survey.sdk.entity.SurveyListEntity
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class SerializerTest {
    @Test
    fun testSerializeSurveyListEntityHappyCase() {
        val rs = TestUtil.getDataFromJson<SurveyListEntity>(JSON_SURVEY_LIST_TEST)
        assertNotNull(rs)
        val resultEntity = rs!!
        assertNotNull(resultEntity.data)
        assertTrue(resultEntity.data.isNotEmpty())
        //item test
        val firstItem = resultEntity.data[0]
        //attributes test
        assertNotNull(firstItem.attributes)
        assertTrue(firstItem.attributes?.title == "Scarlett Bangkok")
        assertTrue(firstItem.attributes?.description == "We'd love ot hear from you!")
        assertTrue(firstItem.attributes?.thankEmailAboveThreshold == "Test1")
        assertTrue(firstItem.attributes?.thankEmailBelowThreshold == "Test2")
        assertTrue(firstItem.attributes?.isActive == true)
        assertTrue(firstItem.attributes?.coverImageURL == "https://dhdbhh0jsld0o.cloudfront.net/m/1ea51560991bcb7d00d0_")
        assertTrue(firstItem.attributes?.createdAt == "2017-01-23T07:48:12.991Z")
        assertTrue(firstItem.attributes?.activeAt == "2015-10-08T07:04:00.000Z")
        assertTrue(firstItem.attributes?.surveyType == "Restaurant")

        //relationship test
        assertNotNull(firstItem.relationships)
        assertNotNull(firstItem.relationships?.questions)
        assertNotNull(firstItem.relationships?.questions?.data)
        assertTrue(firstItem.relationships?.questions?.data?.isNotEmpty() ?: false)
        //first data test
        val firstData = firstItem.relationships?.questions?.data?.first()
        assertTrue(firstData?.id == "d3afbcf2b1d60af845dc")
        assertTrue(firstData?.type == "question")

        //meta test
        assertNotNull(resultEntity.meta)
        assertTrue(resultEntity.meta.page == 1)
        assertTrue(resultEntity.meta.pages == 10)
        assertTrue(resultEntity.meta.pageSize == 2)
        assertTrue(resultEntity.meta.records == 20)
    }

    @Test
    fun testSerializeSurveyDetailHappyCase() {
        val rs = TestUtil.getDataFromJson<SurveyDetailEntity>(JSON_SURVEY_DETAIL_TEST)
        assertNotNull(rs)
        val detailEntity = rs!!
        //data test
        assertNotNull(detailEntity.data)
        val data = detailEntity.data
        assertTrue(data.id == "d5de6a8f8f5f1cfe51bc")
        assertTrue(data.type == "survey")
        //attributes test
        assertNotNull(detailEntity.data.attributes)
        val attributes = detailEntity.data.attributes
        assertTrue(attributes?.title == "Scarlett Bangkok")
        assertTrue(attributes?.description == "We'd love ot hear from you!")
        assertTrue(attributes?.thankEmailAboveThreshold == "Test1")
        assertTrue(attributes?.thankEmailBelowThreshold == "Test2")
        assertTrue(attributes?.isActive == true)
        assertTrue(attributes?.coverImageURL == "https://dhdbhh0jsld0o.cloudfront.net/m/1ea51560991bcb7d00d0_")
        assertTrue(attributes?.createdAt == "2017-01-23T07:48:12.991Z")
        assertTrue(attributes?.activeAt == "2015-10-08T07:04:00.000Z")
        assertTrue(attributes?.surveyType == "Restaurant")

        //relationship test
        assertNotNull(data.relationships)
        val relationships = data.relationships
        assertNotNull(relationships?.questions)
        assertNotNull(relationships?.questions?.data)
        assertTrue(relationships?.questions?.data?.isNotEmpty() ?: false)
        //first data test
        val firstData = relationships?.questions?.data?.first()
        assertTrue(firstData?.id == "d3afbcf2b1d60af845dc")
        assertTrue(firstData?.type == "question")
        //included test
        assertNotNull(detailEntity.included)
        val included = detailEntity.included!!
        assertTrue(included.isNotEmpty())
        val firstIncluded = included.first()
        assertTrue(firstIncluded.id == "d3afbcf2b1d60af845dc")
        assertTrue(firstIncluded.id == "d3afbcf2b1d60af845dc")
        assertNotNull(firstIncluded.attributes)
        assertNotNull(firstIncluded.relationships)

    }

}

package co.nimblehq.sample.ui.surveylist

import co.nimblehq.surveysdk.entity.SurveyDetailEntity

/**
 * Survey List that is exposed to the UI
 */
data class SurveyListModel(
    val listSurvey: List<SurveyDetailEntity>,
)

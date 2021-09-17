package co.nimblehq.sample.ui.surveylist

import co.nimblehq.survey.sdk.entity.SurveyEntity

/**
 * Survey List that is exposed to the UI
 */
data class SurveyListModel(
    val listSurvey: List<SurveyEntity>,
)

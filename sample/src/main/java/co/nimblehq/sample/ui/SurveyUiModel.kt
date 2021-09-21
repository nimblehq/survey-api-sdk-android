package co.nimblehq.sample.ui

data class SurveyUiModel<T> constructor(
    val success: T? = null,
    val error: Int? = null
)

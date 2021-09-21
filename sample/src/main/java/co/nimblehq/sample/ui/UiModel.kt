package co.nimblehq.sample.ui

data class UiModel<T> constructor(
    val success: T? = null,
    val error: Int? = null
)

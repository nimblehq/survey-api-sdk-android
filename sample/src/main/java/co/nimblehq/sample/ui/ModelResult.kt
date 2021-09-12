package co.nimblehq.sample.ui

data class ModelResult<T> constructor(
    val success: T? = null,
    val error: Int? = null
)

package co.nimblehq.survey.sdk

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class ResultSdk<out T : Any> {

    data class Success<out T : Any>(val data: T) : ResultSdk<T>()
    data class Error(val exception: Exception) : ResultSdk<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}

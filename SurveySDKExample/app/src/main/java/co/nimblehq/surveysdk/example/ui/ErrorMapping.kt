package co.nimblehq.surveysdk.example.ui

import android.content.Context
import co.nimblehq.surveysdk.example.R

fun Throwable.userReadableMessage(context: Context): String {
    // TODO implement user readable message
    return context.getString(R.string.error_generic)
}

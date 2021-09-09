package co.nimblehq.surveysdk.example.ui.base

import co.nimblehq.surveysdk.example.ui.screens.second.SecondBundle

sealed class NavigationEvent {
    data class Second(val bundle: SecondBundle) : NavigationEvent()
    object Compose : NavigationEvent()
}

package co.nimblehq.surveysdk.example.ui.screens

import androidx.fragment.app.Fragment
import co.nimblehq.surveysdk.example.R
import co.nimblehq.surveysdk.example.ui.base.BaseNavigator
import co.nimblehq.surveysdk.example.ui.base.BaseNavigatorImpl
import co.nimblehq.surveysdk.example.ui.base.NavigationEvent
import co.nimblehq.surveysdk.example.ui.screens.home.HomeFragmentDirections
import co.nimblehq.surveysdk.example.ui.screens.second.SecondBundle
import javax.inject.Inject

interface MainNavigator : BaseNavigator

class MainNavigatorImpl @Inject constructor(
    fragment: Fragment
) : BaseNavigatorImpl(fragment), MainNavigator {

    override val navHostFragmentId = R.id.navHostFragment

    override fun navigate(event: NavigationEvent) {
        when (event) {
            is NavigationEvent.Second -> navigateToSecond(event.bundle)
            is NavigationEvent.Compose -> navigateToCompose()
        }
    }

    private fun navigateToSecond(bundle: SecondBundle) {
        val navController = findNavController()
        when (navController?.currentDestination?.id) {
            R.id.homeFragment -> navController.navigate(
                HomeFragmentDirections.actionHomeFragmentToSecondFragment(bundle)
            )
            else -> unsupportedNavigation()
        }
    }

    private fun navigateToCompose() {
    }
}

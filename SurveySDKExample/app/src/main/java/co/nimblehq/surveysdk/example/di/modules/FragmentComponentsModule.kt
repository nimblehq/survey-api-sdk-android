package co.nimblehq.surveysdk.example.di.modules

import co.nimblehq.surveysdk.example.ui.screens.MainNavigator
import co.nimblehq.surveysdk.example.ui.screens.MainNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
abstract class NavigatorModule {

    @Binds
    abstract fun mainNavigator(mainNavigator: MainNavigatorImpl): MainNavigator
}

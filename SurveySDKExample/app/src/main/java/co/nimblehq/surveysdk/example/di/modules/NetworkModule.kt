package co.nimblehq.surveysdk.example.di.modules

import co.nimblehq.surveysdk.example.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideBaseApiUrl() = BuildConfig.BASE_URL

}

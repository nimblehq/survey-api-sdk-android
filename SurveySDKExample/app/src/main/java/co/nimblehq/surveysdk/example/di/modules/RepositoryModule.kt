package co.nimblehq.surveysdk.example.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

//    @Provides
//    fun provideUserRepository(apiService: ApiService): UserRepository = UserRepositoryImpl(apiService)
}

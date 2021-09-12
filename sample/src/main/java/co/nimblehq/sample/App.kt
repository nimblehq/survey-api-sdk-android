package co.nimblehq.sample

import android.app.Application
import co.nimblehq.surveysdk.SurveyApi

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        SurveyApi.setup()
            .withMode(BuildConfig.DEBUG)
            .withBaseUrl(BuildConfig.BASE_URL)
            .withClientId(BuildConfig.CLIENT_ID)
            .withClientSecret(BuildConfig.CLIENT_SECRET)
            .build()

    }
}

package co.nimblehq.sample

import android.app.Application
import co.nimblehq.survey.sdk.SurveyApi

class SampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        SurveyApi.instance
            .withMode(BuildConfig.DEBUG)
            .withBaseUrl(BuildConfig.BASE_URL)
            .withCredentials(
                clientID = BuildConfig.CLIENT_ID,
                clientSecret = BuildConfig.CLIENT_SECRET
            )
    }
}

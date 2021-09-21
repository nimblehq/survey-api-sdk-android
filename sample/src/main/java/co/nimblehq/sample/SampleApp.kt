package co.nimblehq.sample

import android.app.Application
import co.nimblehq.survey.sdk.SurveyApi
import co.nimblehq.survey.sdk.request.Credentials

class SampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        SurveyApi.instance
            .withMode(BuildConfig.DEBUG)
            .withBaseUrl(BuildConfig.BASE_URL)
            .withCredentials(
                Credentials(
                    clientID = BuildConfig.CLIENT_ID,
                    clientSecret = BuildConfig.CLIENT_SECRET
                )
            )
    }
}

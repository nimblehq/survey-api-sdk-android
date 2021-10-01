# Survey Api Sdk Android

[![](https://jitpack.io/v/nimblehq/survey-api-sdk-android.svg)](https://jitpack.io/#nimblehq/survey-api-sdk-android)

An Android SDK that supports the interactions with
our [Survey-API](https://github.com/nimblehq/nimble-survey-web), allowing the users to get all
surveys `/surveys` or get a survey by id `/surveys/{id}`. The SDK is also able to handle all
requests for an API without redefining Networking stuff (like `Retrofit`, `OkHttp`, etc).

## Installation

Step 1. Add the JitPack repository to your build file

    ```
    allprojects {
        repositories {
            ...
            maven { url "https://jitpack.io" }
        }
    }
    ```

Step 2. Add the dependency

    ```
    dependencies {
        implementation 'com.github.nimblehq:survey-api-sdk-android:[LATEST_VERSION]'
    }
    ```

## Usage

- Setup the SDK inside `onCreate` function of the `Application` class

    ```
    SurveyApi.instance
                .withMode(BuildConfig.DEBUG) // If debug, it will have log on http request (Optional)
                .withBaseUrl(BuildConfig.BASE_URL) // Base url to call the request
                .withCredentials(// Setup credentials information
                    Credentials(
                        clientID = BuildConfig.CLIENT_ID,
                        clientSecret = BuildConfig.CLIENT_SECRET
                    )
                )        
     ```

- Update token to SDK after having it (by Authentication step, for example)

    ```
    with(SurveyApi.instance) {
          setAccessToken(login.accessToken)
          setTokenType(login.tokenType)
    }
    ```

- To get a list of surveys, use `getSurveyList` with the corresponding pagination parameters

    ```
    SurveyApi.instance.getSurveyList(page = 1, size = 10, onResponse = {
                // Handle it as the `Result.Success` or `Result.Error`
                
    })     
    ```

- To get a survey detail, use `getSurveyDetail` with the corresponding `survey id`

    ```
    SurveyApi.instance.getSurveyDetail(surveyId = id, onResponse = {
                // Handle it as the `Result.Success` or `Result.Error`
                
    })      
    ```

## License

This project is Copyright (c) 2014 and onwards. It is free software, and may be redistributed under
the terms specified in the [LICENSE] file.

[LICENSE]: /LICENSE

## About

![Nimble](https://assets.nimblehq.co/logo/dark/logo-dark-text-160.png)

This project is maintained and funded by Nimble.

We love open source and do our part in sharing our work with the community!
See [our other projects][community] or [hire our team][hire] to help build your product.

[community]: https://github.com/nimblehq

[hire]: https://nimblehq.co/

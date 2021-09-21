package co.nimblehq.survey.sdk.request

data class Credentials(val clientID: String, val clientSecret: String) {
    constructor() : this("", "")
}


package co.nimblehq.surveysdk.example.ui.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import co.nimblehq.surveyapi.TestSDKClass
import co.nimblehq.surveysdk.example.databinding.ActivityMainBinding
import co.nimblehq.surveysdk.example.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = { inflater -> ActivityMainBinding.inflate(inflater) }

    override val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        test()
    }

    private fun test() {
        val tmp = TestSDKClass.testFromSDK()
        Log.e("MainActivity","Test from SDK : $tmp")
    }

}

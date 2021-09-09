package co.nimblehq.surveysdk.example.ui.screens

import android.view.LayoutInflater
import androidx.activity.viewModels
import co.nimblehq.surveysdk.example.databinding.ActivityMainBinding
import co.nimblehq.surveysdk.example.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = { inflater -> ActivityMainBinding.inflate(inflater) }

    override val viewModel by viewModels<MainViewModel>()
}

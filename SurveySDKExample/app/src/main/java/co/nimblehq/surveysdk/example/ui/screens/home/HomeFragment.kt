package co.nimblehq.surveysdk.example.ui.screens.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import co.nimblehq.surveysdk.example.databinding.FragmentHomeBinding
import co.nimblehq.surveysdk.example.databinding.ViewLoadingBinding
import co.nimblehq.surveysdk.example.extension.visibleOrGone
import co.nimblehq.surveysdk.example.lib.IsLoading
import co.nimblehq.surveysdk.example.ui.base.BaseFragment
import co.nimblehq.surveysdk.example.ui.screens.MainNavigator
import co.nimblehq.surveysdk.example.ui.screens.second.SecondBundle
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    @Inject
    lateinit var navigator: MainNavigator

    private val viewModel: HomeViewModel by viewModels()

    private lateinit var viewLoadingBinding: ViewLoadingBinding

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = { inflater, container, attachToParent ->
            FragmentHomeBinding.inflate(inflater, container, attachToParent)
        }

    override fun setupView() {
        viewLoadingBinding = ViewLoadingBinding.bind(binding.root)
    }

    override fun bindViewEvents() {
        super.bindViewEvents()

        with(binding) {
            btNext.setOnClickListener {
                viewModel.navigateToSecond(SecondBundle("From home"))
            }

        }
    }

    override fun bindViewModel() {
        viewModel.showLoading bindTo ::bindLoading
        viewModel.error bindTo toaster::display
        viewModel.navigator bindTo navigator::navigate
    }


    private fun bindLoading(isLoading: IsLoading) {
        viewLoadingBinding.pbLoading.visibleOrGone(isLoading)
    }
}

package ssnd.mobile.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ssnd.mobile.databinding.FragmentAboutBinding
import ssnd.mobile.net.NetworkData
import ssnd.mobile.ui.collect

@AndroidEntryPoint
class AboutFragment : Fragment() {

    private lateinit var binding: FragmentAboutBinding
    private val viewModel: AboutViewModel by viewModels()

    override fun onCreateView(i: LayoutInflater, c: ViewGroup?, s: Bundle?): View =
        FragmentAboutBinding.inflate(i, c, false).let { binding = it; it.root }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        collect(viewModel.gitHubRepos) { data ->
            binding.progress.isVisible = data is NetworkData.Loading
            binding.text.isVisible = data !is NetworkData.Loading
            when(data) {
                is NetworkData.Error -> binding.text.text = data.error.message
                is NetworkData.Success -> binding.text.text = data.data[0].name
                else -> { }
            }
        }
    }
}
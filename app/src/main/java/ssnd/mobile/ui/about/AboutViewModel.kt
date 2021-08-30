package ssnd.mobile.ui.about

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ssnd.mobile.di.Api
import ssnd.mobile.net.request
import javax.inject.Inject

@HiltViewModel
class AboutViewModel @Inject constructor(private val api: Api) : ViewModel() {

    val gitHubRepos = request { api.gitHubService.listRepos("vizghar") }

}
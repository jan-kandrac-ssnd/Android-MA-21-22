package ssnd.mobile.ui.about

import androidx.lifecycle.ViewModel
import ssnd.mobile.net.request
import ssnd.mobile.net.services.GitHubService

class AboutViewModel(private val gitHubService: GitHubService) : ViewModel() {

    val gitHubRepos = request { gitHubService.listRepos("vizghar") }

}
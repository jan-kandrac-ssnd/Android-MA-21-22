package ssnd.mobile.di

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ssnd.mobile.net.services.GitHubService
import javax.inject.Inject

class Api @Inject constructor() {

    private var githubRetrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val gitHubService: GitHubService = githubRetrofit.create(GitHubService::class.java)

}
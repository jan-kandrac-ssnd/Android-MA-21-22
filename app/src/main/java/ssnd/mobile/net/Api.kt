package ssnd.mobile.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ssnd.mobile.net.services.GitHubService

private var githubRetrofit = Retrofit.Builder()
    .baseUrl("https://api.github.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var githubApiService: GitHubService = githubRetrofit.create(GitHubService::class.java)

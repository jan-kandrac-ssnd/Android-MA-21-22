package ssnd.mobile.net.services

import retrofit2.http.GET
import retrofit2.http.Path
import ssnd.mobile.net.model.Repo

interface GitHubService {

    @GET("users/{user}/repos")
    suspend fun listRepos(@Path("user") user: String?): List<Repo>

}
package com.dmap.githubrepositories.data

import com.dmap.githubrepositories.data.model.RepositoriesResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface RepositoryService {
    @GET("/repositories")
    fun getRepositories(): Call<Array<RepositoriesResponseItem>>
}
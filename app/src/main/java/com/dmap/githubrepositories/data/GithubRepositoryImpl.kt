package com.dmap.githubrepositories.data

import com.dmap.githubrepositories.data.model.RepositoriesResponse
import com.dmap.githubrepositories.data.model.RepositoriesResponseItem
import com.dmap.githubrepositories.domain.GithubRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubRepositoryImpl(
    override val service: RepositoryService
) : GithubRepository {

    override fun getRepositories(callback: Callback<RepositoriesResponse>) {

         service.getRepositories().enqueue(object : Callback<Array<RepositoriesResponseItem>> {

             override fun onResponse(
                 call: Call<RepositoriesResponse>,
                 response: Response<RepositoriesResponse>
             ) { response.body()?.let {
                 callback.onResponse(call, Response.success(it)) }
             }

             override fun onFailure(call: Call<RepositoriesResponse>, t: Throwable) {
                 callback.onFailure(call, t)
             }
         })
    }
}
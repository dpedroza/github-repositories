package com.dmap.githubrepositories.domain

import com.dmap.githubrepositories.data.RepositoryService
import com.dmap.githubrepositories.data.model.RepositoriesResponseItem
import retrofit2.Callback

interface GithubRepository {
    val service: RepositoryService
    fun getRepositories(callback: Callback<Array<RepositoriesResponseItem>>)
}
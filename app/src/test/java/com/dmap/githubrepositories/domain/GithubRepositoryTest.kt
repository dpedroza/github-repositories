package com.dmap.githubrepositories.domain

import com.dmap.githubrepositories.data.GithubRepositoryImpl
import com.dmap.githubrepositories.data.RepositoryService
import com.dmap.githubrepositories.data.model.RepositoriesResponse
import com.dmap.githubrepositories.data.model.RepositoriesResponseItem
import org.junit.Before
import org.junit.Test
import org.mockito.*
import org.mockito.Mockito.verify
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubRepositoryTest {

    lateinit var repository: GithubRepository

    @Mock
    lateinit var mockCall: Call<RepositoriesResponse>

    @Mock
    lateinit var mockCallback: Callback<RepositoriesResponse>

    @Mock
    lateinit var service: RepositoryService

    @Captor
    lateinit var argumentCapture: ArgumentCaptor<Callback<RepositoriesResponse>>

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        repository = GithubRepositoryImpl(service)
    }

    @Test
    fun getRepositoriesSuccessBehavior() {
        // given
        Mockito.`when`(service.getRepositories()).thenReturn(mockCall)
        val response = Response.success( emptyArray<RepositoriesResponseItem>() )

        // when
        repository.getRepositories(mockCallback)

        //then
        verify(mockCall).enqueue(argumentCapture.capture())

        argumentCapture.value.onResponse(mockCall, response)

        verify( service ).getRepositories()
    }
}
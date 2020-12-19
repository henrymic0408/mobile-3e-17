package com.example.retrofitexample.services

import com.example.retrofitexample.models.RepositoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String) : Call<List<RepositoryResponse>>
}
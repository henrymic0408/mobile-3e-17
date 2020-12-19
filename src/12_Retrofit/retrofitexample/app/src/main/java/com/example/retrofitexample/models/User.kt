package com.example.retrofitexample.models

data class User(
    val username: String,
    val listRepository: ArrayList<RepositoryResponse>
)
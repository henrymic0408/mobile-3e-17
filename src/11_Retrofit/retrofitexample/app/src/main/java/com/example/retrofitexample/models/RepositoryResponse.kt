package com.example.retrofitexample.models

import com.google.gson.annotations.SerializedName

data class RepositoryResponse(
    @SerializedName("id")
    val id: Int,

    @SerializedName("html_url")
    val htmlUrl: String,

    @SerializedName("full_name")
    val fullName: String,

    @SerializedName("owner")
    val owner: OwnerResponse
)
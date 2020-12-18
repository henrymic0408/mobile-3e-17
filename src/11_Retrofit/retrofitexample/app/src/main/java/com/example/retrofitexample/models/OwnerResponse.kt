package com.example.retrofitexample.models

import com.google.gson.annotations.SerializedName

data class OwnerResponse(
    @SerializedName("id")
    val id: Int,

    @SerializedName("avatar_url")
    val avatar: String
)
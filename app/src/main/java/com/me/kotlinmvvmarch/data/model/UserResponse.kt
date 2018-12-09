package com.me.kotlinmvvmarch.data.model

import com.google.gson.annotations.SerializedName

data class UserResponse(
        @SerializedName("age")
        val age: Int?,
        @SerializedName("name")
        val name: String?
)
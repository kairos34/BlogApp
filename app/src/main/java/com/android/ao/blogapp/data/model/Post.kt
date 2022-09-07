package com.android.ao.blogapp.data.model

import androidx.annotation.Keep

@Keep
data class Post(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)
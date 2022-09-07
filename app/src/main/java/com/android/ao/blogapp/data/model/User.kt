package com.android.ao.blogapp.data.model

import androidx.annotation.Keep

@Keep
data class User(
    val name: String,
    val thumbnailUrl: String,
    val url: String,
    val userId: Int
)
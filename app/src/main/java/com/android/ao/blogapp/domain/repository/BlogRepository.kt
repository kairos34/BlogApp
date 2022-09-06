package com.android.ao.blogapp.domain.repository

import com.android.ao.blogapp.data.model.Post
import com.android.ao.blogapp.data.model.User

interface BlogRepository {
    suspend fun getUsers(): List<User>
    suspend fun getPosts(): List<Post>
}
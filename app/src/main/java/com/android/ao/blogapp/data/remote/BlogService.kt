package com.android.ao.blogapp.data.remote

import com.android.ao.blogapp.data.model.Post
import com.android.ao.blogapp.data.model.User
import retrofit2.http.GET

interface BlogService {
    @GET("users")
    suspend fun getUsers(): List<User>
    @GET("posts")
    suspend fun getPosts(): List<Post>
}
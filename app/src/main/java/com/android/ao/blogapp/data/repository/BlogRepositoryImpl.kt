package com.android.ao.blogapp.data.repository

import com.android.ao.blogapp.data.model.Post
import com.android.ao.blogapp.data.model.User
import com.android.ao.blogapp.data.remote.BlogService
import com.android.ao.blogapp.domain.repository.BlogRepository
import javax.inject.Inject

class BlogRepositoryImpl @Inject constructor(
    private val blogService: BlogService
): BlogRepository {
    override suspend fun getUsers(): List<User> = blogService.getUsers()
    override suspend fun getPosts(): List<Post> = blogService.getPosts()
}
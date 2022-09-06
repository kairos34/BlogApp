package com.android.ao.blogapp.domain.model

import com.android.ao.blogapp.data.model.Post
import com.android.ao.blogapp.data.model.User

data class UserWithPosts(
    val user: User,
    val posts: List<Post>
)
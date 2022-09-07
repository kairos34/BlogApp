package com.android.ao.blogapp.domain.usecases

import com.android.ao.blogapp.data.model.Post
import com.android.ao.blogapp.data.model.User
import com.android.ao.blogapp.domain.model.UserWithPosts
import javax.inject.Inject

class CreateUsersWithPostsUseCase @Inject constructor() {
    operator fun invoke(users: List<User>, posts: List<Post>): List<UserWithPosts> =
        users.map { user ->
            UserWithPosts(user, posts.filter {
                it.userId == user.userId
            })
        }
}
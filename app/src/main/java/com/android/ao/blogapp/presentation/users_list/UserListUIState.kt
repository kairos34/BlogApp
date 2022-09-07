package com.android.ao.blogapp.presentation.users_list

import com.android.ao.blogapp.domain.model.UserWithPosts

data class UserListUIState(
    val isLoading: Boolean = false,
    val usersWithPosts: List<UserWithPosts>? = null,
    val error: String = ""
)
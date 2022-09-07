package com.android.ao.blogapp.presentation.users_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.ao.blogapp.domain.model.UserWithPosts
import com.android.ao.blogapp.presentation.common.ErrorView
import com.android.ao.blogapp.presentation.users_detail.components.UserPostItem
import com.android.ao.blogapp.presentation.users_detail.components.UserPostsImageItem

@Composable
fun UsersDetailScreen(userWithPosts: UserWithPosts) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        UserPostsImageItem(imageUrl = userWithPosts.user.url)
        Spacer(modifier = Modifier.height(5.dp))
        if (userWithPosts.posts.isNotEmpty()) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                with(userWithPosts.posts) {
                    items(this.size) { index ->
                        UserPostItem(userPost = this@with[index])
                    }
                }
            }
        } else {
            ErrorView(message = "User does not have any post!")
        }
    }
}
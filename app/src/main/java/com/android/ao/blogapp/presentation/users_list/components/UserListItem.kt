package com.android.ao.blogapp.presentation.users_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.ao.blogapp.domain.model.UserWithPosts

@Composable
fun UserListItem(
    userWithPosts: UserWithPosts,
    onItemClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        backgroundColor = MaterialTheme.colors.primaryVariant,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick()
            }
            .padding(
                bottom = 5.dp,
                top = 5.dp,
                start = 20.dp,
                end = 20.dp
            )
    ) {
        Row(
            modifier = Modifier.height(IntrinsicSize.Max),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            UserImageItem(imageUrl = userWithPosts.user.thumbnailUrl)
            UserInfoItem(
                userName = userWithPosts.user.name,
                postCount = userWithPosts.posts.size
            )
        }
    }
}
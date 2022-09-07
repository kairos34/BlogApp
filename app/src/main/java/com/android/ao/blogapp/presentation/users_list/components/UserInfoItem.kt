package com.android.ao.blogapp.presentation.users_list.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.android.ao.blogapp.presentation.theme.secondaryColor

@Composable
fun UserInfoItem(userName: String, postCount: Int) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = userName,
            style = MaterialTheme.typography.h2.copy(
                color = secondaryColor
            ),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Posts count  •  $postCount",
            style = MaterialTheme.typography.h4.copy(
                fontWeight = FontWeight.Medium,
                fontStyle = FontStyle.Italic
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 4.dp),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}
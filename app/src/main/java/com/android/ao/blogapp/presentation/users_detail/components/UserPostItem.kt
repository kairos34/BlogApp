package com.android.ao.blogapp.presentation.users_detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.android.ao.blogapp.data.model.Post
import com.android.ao.blogapp.presentation.theme.secondaryDarkColor

@Composable
fun UserPostItem(userPost: Post) {
    Card(
        shape = RoundedCornerShape(10.dp),
        backgroundColor = secondaryDarkColor,
        modifier = Modifier
            .fillMaxWidth()
            .size(192.dp)
            .padding(
                bottom = 5.dp,
                top = 5.dp,
                start = 10.dp,
                end = 10.dp
            )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = userPost.title,
                style = MaterialTheme.typography.h2.copy(
                    color = MaterialTheme.colors.primary
                ),
                textAlign = TextAlign.Center
            )
            Text(
                text = userPost.body,
                style = MaterialTheme.typography.h6.copy(
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic
                ),
                textAlign = TextAlign.Center
            )
        }
    }
}
package com.android.ao.blogapp.presentation.users_detail.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import com.android.ao.blogapp.R
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun UserPostsImageItem(imageUrl: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .size(256.dp),
        shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 0.dp,
            bottomStart = 10.dp,
            bottomEnd = 10.dp
        )
    ) {
        CoilImage(
            imageModel = imageUrl,
            imageLoader = {
                ImageLoader.Builder(LocalContext.current)
                    .availableMemoryPercentage(0.25)
                    .build()
            },
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            circularReveal = CircularReveal(duration = 350),
            error = ImageBitmap.imageResource(R.drawable.placeholder)
        )
    }
}
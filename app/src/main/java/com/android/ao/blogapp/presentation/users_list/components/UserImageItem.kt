package com.android.ao.blogapp.presentation.users_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import com.android.ao.blogapp.R
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun UserImageItem(imageUrl: String) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .size(128.dp)
            .clip(CircleShape)) {
        CoilImage(
            imageModel = imageUrl,
            imageLoader = {
                ImageLoader.Builder(LocalContext.current)
                    .availableMemoryPercentage(0.25)
                    .build()
            },
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            shimmerParams = ShimmerParams(
                baseColor = MaterialTheme.colors.background,
                highlightColor = MaterialTheme.colors.primary,
                durationMillis = 350,
                dropOff = 0.65f,
                tilt = 20f
            ),
            error = ImageBitmap.imageResource(R.drawable.placeholder)
        )
    }
}
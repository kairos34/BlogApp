package com.android.ao.blogapp.presentation.splash

import androidx.compose.runtime.Composable
import com.android.ao.blogapp.presentation.splash.components.AppDeveloperItem
import com.android.ao.blogapp.presentation.splash.components.AppLogoItem

@Composable
fun SplashScreen(navigateToUsersList: () -> Unit) {
    AppLogoItem(navigateToUsersList)
    AppDeveloperItem()
}
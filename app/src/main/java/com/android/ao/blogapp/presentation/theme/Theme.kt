package com.android.ao.blogapp.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = secondaryColor,
    primaryVariant = secondaryDarkColor,
    onPrimary = Color.Black,
    secondary = secondaryLightColor,
    onSecondary = Color.Black,
    error = errorColor,
    onBackground = Color.White
)

private val LightColorPalette = lightColors(
    primary = primaryColor,
    primaryVariant = primaryDarkColor,
    onPrimary = Color.White,
    secondary = primaryLightColor,
    secondaryVariant = primaryDarkColor,
    onSecondary = Color.White,
    error = errorColor,
    onBackground = Color.Black,
)

@Composable
fun BlogAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(
        colors = if (darkTheme) DarkColorPalette else LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
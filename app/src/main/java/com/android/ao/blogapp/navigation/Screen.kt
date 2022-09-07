package com.android.ao.blogapp.navigation

sealed class Screen(val route: String) {
    object UsersListScreen : Screen("users_list_screen")
    object UsersDetailScreen : Screen("users_detail_screen")
    object SplashScreen: Screen("splash_screen")
}
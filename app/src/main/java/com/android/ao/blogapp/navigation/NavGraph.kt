package com.android.ao.blogapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android.ao.blogapp.presentation.users_list.UsersListScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.UsersListScreen.route,
    ) {
        composable(
            route = Screen.UsersListScreen.route
        ) {
            UsersListScreen {
                navController.navigate(Screen.UsersDetailScreen.route + "/${it}")
            }
        }
    }
}
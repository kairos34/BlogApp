package com.android.ao.blogapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android.ao.blogapp.common.Constants
import com.android.ao.blogapp.presentation.splash.SplashScreen
import com.android.ao.blogapp.presentation.users_detail.UsersDetailScreen
import com.android.ao.blogapp.presentation.users_list.UsersListScreen
import com.android.ao.blogapp.presentation.users_list.UsersListViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModel: UsersListViewModel = hiltViewModel(),
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
    ) {
        composable(
            route = Screen.SplashScreen.route
        ) {
            SplashScreen {
                navController.navigate(Screen.UsersListScreen.route) {
                    popUpTo(Screen.SplashScreen.route) {
                        inclusive = true
                    }
                }
            }
        }
        composable(
            route = Screen.UsersListScreen.route
        ) {
            UsersListScreen(viewModel) {
                navController.navigate(Screen.UsersDetailScreen.route + "/${it}")
            }
        }
        composable(
            route = Screen.UsersDetailScreen.route + "/{${Constants.PARAM_USER_INDEX}}"
        ) { backStackEntry ->
            val index = backStackEntry.arguments?.getString(Constants.PARAM_USER_INDEX)?.toInt() ?: 0
            viewModel.usersListUIState.collectAsState().value.usersWithPosts?.get(index)?.run {
                UsersDetailScreen(this)
            }
        }
    }
}
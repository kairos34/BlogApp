package com.android.ao.blogapp.presentation.users_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.android.ao.blogapp.presentation.common.ErrorView
import com.android.ao.blogapp.presentation.common.LoadingView
import com.android.ao.blogapp.presentation.users_list.components.UserListItem


@Composable
fun UsersListScreen(
    viewModel: UsersListViewModel,
    navigateToUserDetail: (Int) -> Unit,
) {
    val usersListUIState by viewModel.usersListUIState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            usersListUIState.usersWithPosts?.let {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(it.size) { index ->
                        UserListItem(userWithPosts = it[index]) {
                            navigateToUserDetail.invoke(index)
                        }
                    }
                }
            }
            if (usersListUIState.error.isNotBlank()) {
                ErrorView(
                    message = usersListUIState.error,
                    onClickRetry = { viewModel.getUsers() }
                )
            }
            if (usersListUIState.isLoading) {
                LoadingView()
            }
        }
    }

}
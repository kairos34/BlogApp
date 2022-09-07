package com.android.ao.blogapp.presentation.users_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.ao.blogapp.common.Resource
import com.android.ao.blogapp.domain.usecases.GetUsersWithPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class UsersListViewModel @Inject constructor(
    private val getPostsWithUsersUseCase: GetUsersWithPostsUseCase
) : ViewModel() {

    private val _usersListUIState = MutableStateFlow(UserListUIState())
    val usersListUIState: StateFlow<UserListUIState> = _usersListUIState.asStateFlow()

    init {
        getUsers()
    }

    fun getUsers() {
        getPostsWithUsersUseCase().onEach { usersWithPostsResult ->
            when(usersWithPostsResult) {
                is Resource.Success -> {
                    _usersListUIState.value = UserListUIState(
                        usersWithPosts = usersWithPostsResult.data
                    )
                }
                is Resource.Error -> {
                    _usersListUIState.value = UserListUIState(
                        error = usersWithPostsResult.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _usersListUIState.value = UserListUIState(isLoading = true)
                }

            }
        }.launchIn(viewModelScope)
    }
}
package com.android.ao.blogapp.domain.usecases

import com.android.ao.blogapp.common.Resource
import com.android.ao.blogapp.domain.model.UserWithPosts
import com.android.ao.blogapp.domain.repository.BlogRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPostsWithUsersUseCase @Inject constructor(
    private val repository: BlogRepository,
    private val getUsersUseCase: GetUsersUseCase,
    private val getPostsUseCase: GetPostsUseCase
){
    operator fun invoke(): Flow<Resource<List<UserWithPosts>>> = flow {
        try {
            emit(Resource.Loading())
            val usersWithPosts = coroutineScope {
                val users = withContext(Dispatchers.IO) {
                    repository.getUsers()
                }
                val posts = withContext(Dispatchers.IO) {
                    repository.getPosts()
                }
                withContext(Dispatchers.IO) {
                    users.map { user ->
                        UserWithPosts(user, posts.filter {
                            it.userId == user.userId
                        })
                    }
                }
            }
            emit(Resource.Success(usersWithPosts))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }

    fun call(): Flow<Resource<List<UserWithPosts>>> = flow {
        getUsersUseCase().zip(getPostsUseCase()) { users, posts ->
            when(users) {
                is Resource.Success -> {
                    when(posts) {
                        is Resource.Success -> {
                            emit(Resource.Success(users.data!!.map { user ->
                                UserWithPosts(user, posts.data!!.filter {
                                    it.userId == user.userId
                                })
                            }))
                        }
                        is Resource.Error -> {
                            emit(Resource.Error(posts.message ?: "An unexpected error occured"))
                        }
                        is Resource.Loading -> {
                            emit(Resource.Loading())
                        }
                    }
                }
                is Resource.Error -> {
                    emit(Resource.Error(users.message ?: "An unexpected error occured"))
                }
                is Resource.Loading -> {
                    emit(Resource.Loading())
                }
            }
        }
    }

}
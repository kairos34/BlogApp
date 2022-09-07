package com.android.ao.blogapp.domain.usecases

import com.android.ao.blogapp.common.Resource
import com.android.ao.blogapp.domain.model.UserWithPosts
import com.android.ao.blogapp.domain.repository.BlogRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUsersWithPostsUseCase @Inject constructor(
    private val blogRepository: BlogRepository,
    private val createUsersWithPostsUseCase: CreateUsersWithPostsUseCase
){
    operator fun invoke(): Flow<Resource<List<UserWithPosts>>> = flow {
        try {
            emit(Resource.Loading())
            val users = blogRepository.getUsers()
            val posts = blogRepository.getPosts()
            val usersWithPosts = createUsersWithPostsUseCase(users, posts)
            emit(Resource.Success(usersWithPosts))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}
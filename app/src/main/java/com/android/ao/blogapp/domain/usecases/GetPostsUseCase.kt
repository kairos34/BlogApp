package com.android.ao.blogapp.domain.usecases

import com.android.ao.blogapp.common.Resource
import com.android.ao.blogapp.data.model.Post
import com.android.ao.blogapp.domain.repository.BlogRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val repository: BlogRepository
) {
    operator fun invoke(): Flow<Resource<List<Post>>> = flow {
        try {
            emit(Resource.Loading())
            val posts = repository.getPosts()
            emit(Resource.Success(posts))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}
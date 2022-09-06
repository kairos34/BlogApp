package com.android.ao.blogapp.di

import com.android.ao.blogapp.data.remote.BlogService
import com.android.ao.blogapp.data.repository.BlogRepositoryImpl
import com.android.ao.blogapp.domain.repository.BlogRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideBlogRepository(service: BlogService): BlogRepository {
        return BlogRepositoryImpl(service)
    }

}
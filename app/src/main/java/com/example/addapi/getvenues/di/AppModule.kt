package com.example.addapi.getvenues.di

import com.example.addapi.getvenues.data.remote.APIHelper
import com.example.addapi.getvenues.data.remote.APIHelperImpl
import com.example.addapi.getvenues.data.remote.APIInterface
import com.example.addapi.getvenues.data.repository.VenuesRepositoriesImpl
import com.example.addapi.getvenues.data.repository.VenuesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    companion object {

        @Provides
        @Singleton
        fun provideApiClient(): Retrofit {
            return Retrofit.Builder().baseUrl("https://api.seatgeek.com").addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Provides
        @Singleton
        fun provideApiInterface(retrofit: Retrofit): APIInterface {
            return retrofit.create(APIInterface::class.java)
        }

        @Provides
        @Singleton
        fun provideDispatcher(): CoroutineDispatcher{
            return Dispatchers.IO
        }

    }

    @Binds
    @Singleton
    abstract fun provideApiHelper(apiHelperImpl: APIHelperImpl): APIHelper

    @Binds
    @Singleton
    abstract fun provideRepository(repositoriesImpl: VenuesRepositoriesImpl): VenuesRepository
}
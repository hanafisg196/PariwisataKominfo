package com.example.pariwisatakominfo.di

import com.example.pariwisatakominfo.common.Constant.BASE_URL
import com.example.pariwisatakominfo.data.ApiService
import com.example.pariwisatakominfo.repository.DestinationsRepo
import com.example.pariwisatakominfo.repository.SearchDestinationRepo
import com.example.pariwisatakominfo.repository.TripDetailRepo
import com.example.pariwisatakominfo.repository.TripsRepo
import com.example.pariwisatakominfo.repository.impl.DestinationsRepoImpl
import com.example.pariwisatakominfo.repository.impl.SearchDestinationRepoImpl
import com.example.pariwisatakominfo.repository.impl.TripDetailRepoImpl
import com.example.pariwisatakominfo.repository.impl.TripsRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApiService(builder:Retrofit.Builder): ApiService {
        return builder
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder{
        return  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Provides
    fun provideDestinationsRepo(api: ApiService): DestinationsRepo = DestinationsRepoImpl(api)
    @Provides
    fun provideTripDetailRepo(api: ApiService): TripDetailRepo = TripDetailRepoImpl(api)
    @Provides
    fun provideSearchDestinationRepo(api: ApiService): SearchDestinationRepo = SearchDestinationRepoImpl(api)
    @Provides
    fun provideTripsRepo(api: ApiService): TripsRepo = TripsRepoImpl(api)



}
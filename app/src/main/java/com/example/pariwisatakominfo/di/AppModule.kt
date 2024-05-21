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
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
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
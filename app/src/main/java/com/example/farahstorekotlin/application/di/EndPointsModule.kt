package com.example.farahstorekotlin.application.di

import com.example.farahstorekotlin.data.api.ProductsEndPoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class EndPointsModule {

    @Provides
    fun provideProductEndPoint(retrofit: Retrofit): ProductsEndPoint =
        retrofit.create(ProductsEndPoint::class.java)
}
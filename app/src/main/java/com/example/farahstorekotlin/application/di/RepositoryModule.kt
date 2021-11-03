package com.example.farahstorekotlin.application.di

import com.example.farahstorekotlin.data.api.ProductsEndPoint
import com.example.farahstorekotlin.data.repository.StoreRepositoryImp
import com.example.farahstorekotlin.domain.repository.StoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideStoreRepository(productsEndPoint: ProductsEndPoint): StoreRepository =
        StoreRepositoryImp(productsEndPoint)

}
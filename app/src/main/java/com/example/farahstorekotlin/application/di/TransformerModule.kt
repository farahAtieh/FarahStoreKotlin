package com.example.farahstorekotlin.application.di

import com.example.farahstorekotlin.data.db.dao.StoreDao
import com.example.farahstorekotlin.data.db.transformer.StoreItemTransformer
import com.example.farahstorekotlin.data.db.transformer.StoreItemTransformerImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TransformerModule {

    @Singleton
    @Provides
    fun provideStoreItemTransformer(storeDao: StoreDao): StoreItemTransformer =
        StoreItemTransformerImp(storeDao)
}
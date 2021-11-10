package com.example.farahstorekotlin.application.di

import android.content.Context
import androidx.room.Room
import com.example.farahstorekotlin.data.db.DatabaseInfo
import com.example.farahstorekotlin.data.db.StoreDatabase
import com.example.farahstorekotlin.data.db.dao.StoreDao
import com.example.farahstorekotlin.data.db.transformer.StoreTransformer
import com.example.farahstorekotlin.data.db.transformer.StoreTransformerImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideStoreDatabase(@ApplicationContext context: Context): StoreDatabase =
        Room.databaseBuilder(
            context,
            StoreDatabase::class.java,
            DatabaseInfo.DatabaseName.STORE_DATABASE
        ).build()

    @Singleton
    @Provides
    fun provideStoreDao(storeDatabase: StoreDatabase): StoreDao =
        storeDatabase.storeDao()

    @Singleton
    @Provides
    fun provideStoreTransformer(storeDao: StoreDao): StoreTransformer =
        StoreTransformerImp(storeDao)
}
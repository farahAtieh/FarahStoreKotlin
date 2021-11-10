package com.example.farahstorekotlin.application.di

import android.content.Context
import androidx.room.Room
import com.example.farahstorekotlin.data.db.StoreDatabase
import com.example.farahstorekotlin.data.db.dao.StoreDao
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
    fun provideDatabase(
        @ApplicationContext context: Context): StoreDatabase = Room.databaseBuilder(context, StoreDatabase::class.java, "StoreDB")
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideStoreDao(storeDatabase: StoreDatabase): StoreDao = storeDatabase.getStoreDao()

}
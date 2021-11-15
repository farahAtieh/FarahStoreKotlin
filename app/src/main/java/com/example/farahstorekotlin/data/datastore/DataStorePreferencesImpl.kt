package com.example.farahstorekotlin.data.datastore

import android.content.Context
import androidx.datastore.migrations.SharedPreferencesView
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.rxjava3.rxPreferencesDataStore
import androidx.datastore.rxjava3.RxDataStore
import androidx.datastore.rxjava3.RxSharedPreferencesMigration
import androidx.datastore.rxjava3.RxSharedPreferencesMigrationBuilder
import com.example.farahstorekotlin.BuildConfig
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

private const val STORE_NAME = BuildConfig.APPLICATION_ID + "_preferences"

class DataStorePreferencesImpl @Inject constructor(
    @ApplicationContext context: Context
): DataStorePreferences{

    private val Context._dataStore: RxDataStore<Preferences> by rxPreferencesDataStore(
        name = STORE_NAME,
        produceMigrations = { context ->
            listOf(
                RxSharedPreferencesMigrationBuilder(
                    context = context,
                    sharedPreferencesName = STORE_NAME,
                    object : RxSharedPreferencesMigration<Preferences>{
                        override fun migrate(
                            sharedPreferencesView: SharedPreferencesView,
                            currentData: Preferences
                        ): Single<Preferences> {
                            val currentKeys = currentData.asMap().keys.map { it.name }

                            val filteredSharedPreferences = sharedPreferencesView
                                .getAll()
                                .filter { (key, _) -> key in currentKeys }

                            val mutablePreferences = currentData.toMutablePreferences()

                            for((key, value ) in filteredSharedPreferences){
                                when(value){
                                    is Boolean -> mutablePreferences[
                                            booleanPreferencesKey(key)
                                    ] = value
                                    is Float -> mutablePreferences[
                                            floatPreferencesKey(key)
                                    ] = value
                                    is Int -> mutablePreferences[
                                            intPreferencesKey(key)
                                    ] = value
                                    is Long -> mutablePreferences[
                                            longPreferencesKey(key)
                                    ] = value
                                    is String -> mutablePreferences[
                                            stringPreferencesKey(key)
                                    ] = value
                                    is Set<*> -> {
                                        @Suppress("UNCHECKED_CAST")
                                        mutablePreferences[
                                                stringSetPreferencesKey(key)
                                        ] = value as Set<String>
                                    }
                                }
                            }

                            return Single.just(mutablePreferences.toPreferences())
                        }

                    }
                ).build()
            )

        }
    )

    override fun setAboutTip(title: String): Flowable<Preferences> {
        TODO("Not yet implemented")
    }

    override fun getAboutTip(): Flowable<String> {
        TODO("Not yet implemented")
    }
}
package com.example.farahstorekotlin.data.datastore

import androidx.datastore.preferences.core.Preferences
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
interface DataStorePreferences {

    fun setAboutTip(title: String): Flowable<Preferences>

    fun getAboutTip(): Flowable<String>
}
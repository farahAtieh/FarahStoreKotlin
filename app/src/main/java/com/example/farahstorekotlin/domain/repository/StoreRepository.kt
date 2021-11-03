package com.example.farahstorekotlin.domain.repository

import com.example.farahstorekotlin.data.model.StoreItem
import io.reactivex.rxjava3.core.Flowable

interface StoreRepository {

    fun getStoresItem(): Flowable<List<StoreItem>>

}
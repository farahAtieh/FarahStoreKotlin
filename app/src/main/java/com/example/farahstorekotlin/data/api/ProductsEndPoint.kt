package com.example.farahstorekotlin.data.api

import com.example.farahstorekotlin.data.model.StoreItem
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

/**
 * created by Farah Atieh on 11/1/2021.
 */
interface ProductsEndPoint {

    @GET("products/")
    fun getStoreItems(): Flowable<List<StoreItem>>

}
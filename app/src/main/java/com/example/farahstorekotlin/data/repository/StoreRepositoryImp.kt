package com.example.farahstorekotlin.data.repository

import com.example.farahstorekotlin.data.api.ProductsEndPoint
import com.example.farahstorekotlin.data.db.transformer.StoreTransformer
import com.example.farahstorekotlin.data.model.StoreItem
import com.example.farahstorekotlin.domain.repository.StoreRepository
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class StoreRepositoryImp
    @Inject constructor(
        private val productsEndPoint: ProductsEndPoint,
        private val storeTransformer: StoreTransformer): StoreRepository {

    override fun getStoresItem(): Flowable<List<StoreItem>> =
        productsEndPoint.getStoreItems()

    override fun addItemToFav(storeItem: StoreItem) {
        storeTransformer.addItemToFav(storeItem)
    }

    override fun deleteItemFromFav(id: Int) {
        storeTransformer.deleteItemFromFav(id)
    }

    override fun getFavItems(): Flowable<List<StoreItem>> {
        return storeTransformer.getFavItems()
    }

}
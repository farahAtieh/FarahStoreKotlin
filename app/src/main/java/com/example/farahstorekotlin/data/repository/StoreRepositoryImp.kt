package com.example.farahstorekotlin.data.repository

import com.example.farahstorekotlin.data.api.ProductsEndPoint
import com.example.farahstorekotlin.data.db.dao.StoreDao
import com.example.farahstorekotlin.data.db.entity.StoreItemEntity
import com.example.farahstorekotlin.data.db.transformer.StoreItemTransformer
import com.example.farahstorekotlin.data.model.StoreItem
import com.example.farahstorekotlin.domain.repository.StoreRepository
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class StoreRepositoryImp
    @Inject constructor(
        private val productsEndPoint: ProductsEndPoint,
        private val storeItemTransformer: StoreItemTransformer): StoreRepository {

    override fun getStoresItem(): Flowable<List<StoreItem>> =
        productsEndPoint.getStoreItems()

    override fun addItemToFav(storeItem: StoreItem) {
        storeItemTransformer.addItemToFav(storeItem);
    }

    override fun deleteItemFromFav(id: Int) {
        storeItemTransformer.deleteItemFromFav(id)
    }

    override fun getFavProducts(): Flowable<List<StoreItem>> =
        storeItemTransformer.getFavProducts()


}
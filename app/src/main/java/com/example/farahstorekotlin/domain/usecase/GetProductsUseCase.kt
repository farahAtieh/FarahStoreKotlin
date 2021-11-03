package com.example.farahstorekotlin.domain.usecase

import com.example.farahstorekotlin.data.model.StoreItem
import com.example.farahstorekotlin.domain.repository.StoreRepository
import dagger.hilt.android.scopes.ViewModelScoped
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

@ViewModelScoped
class GetProductsUseCase
    @Inject constructor(private val storeRepository: StoreRepository) {

        fun getStoreItems(): Flowable<List<StoreItem>> = storeRepository.getStoresItem()
}
package com.example.farahstorekotlin.domain.usecase

import com.example.farahstorekotlin.data.model.StoreItem
import com.example.farahstorekotlin.domain.repository.StoreRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class AddItemToFavUseCase @Inject constructor(private val storeRepository: StoreRepository){

    fun addItemToFav(storeItem: StoreItem){
        storeRepository.addItemToFav(storeItem)
    }
}
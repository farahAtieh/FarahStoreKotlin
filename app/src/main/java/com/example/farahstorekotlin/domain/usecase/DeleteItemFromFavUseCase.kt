package com.example.farahstorekotlin.domain.usecase

import com.example.farahstorekotlin.domain.repository.StoreRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class DeleteItemFromFavUseCase @Inject constructor(
    private val storeRepository: StoreRepository) {

    fun deleteItemFromFav(id: Int){
        storeRepository.deleteItemFromFav(id)
    }
}
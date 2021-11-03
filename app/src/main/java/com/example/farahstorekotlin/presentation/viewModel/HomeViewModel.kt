package com.example.farahstorekotlin.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.RequestManager
import com.example.farahstorekotlin.data.model.StoreItem
import com.example.farahstorekotlin.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject constructor(
        val requestManager: RequestManager,
        private val productsUseCase: GetProductsUseCase): ViewModel() {

    val storeItems = MutableLiveData<List<StoreItem>>()

    init {
        getStoreItems()
    }

    private fun getStoreItems() {
        productsUseCase.getStoreItems()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { items ->
                    storeItems.postValue(items)},
                {throwable ->
                    System.out.println(throwable.message)}
            )
    }
}
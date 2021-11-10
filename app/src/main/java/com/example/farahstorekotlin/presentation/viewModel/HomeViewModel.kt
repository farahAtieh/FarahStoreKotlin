package com.example.farahstorekotlin.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.RequestManager
import com.example.farahstorekotlin.data.db.entity.StoreItemEntity
import com.example.farahstorekotlin.data.model.StoreItem
import com.example.farahstorekotlin.domain.usecase.DeleteItemFromFavUseCase
import com.example.farahstorekotlin.domain.usecase.GetFavProductsUseCase
import com.example.farahstorekotlin.domain.usecase.GetProductsUseCase
import com.example.farahstorekotlin.domain.usecase.InsertItemToFavUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject constructor(
        val requestManager: RequestManager,
        private val productsUseCase: GetProductsUseCase,
        private val deleteItemFromFavUseCase: DeleteItemFromFavUseCase,
        private val addItemToFavUseCase: InsertItemToFavUseCase,
        private val getFavProductsUseCase: GetFavProductsUseCase): ViewModel() {

    val storeItems = MutableLiveData<List<StoreItem>>()
    val favStoreItems = MutableLiveData<List<StoreItem>>()
    val mDisposable = CompositeDisposable()

    init {
        getStoreItems()
    }

    private fun getStoreItems() {
        mDisposable.add(
            productsUseCase.getStoreItems()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { items ->
                        storeItems.postValue(items)},
                    {throwable ->
                        System.out.println(throwable.message)}
                )
        )
    }

    fun getFavProducts(){
        mDisposable.add(
            getFavProductsUseCase.getFavProducts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {items ->
                        favStoreItems.postValue(items)},
                    {throwable ->
                        System.out.println(throwable.message)
                    }
                )
        )
    }

    fun addItemToFav(storeItem: StoreItem){

        Completable.fromRunnable {
            addItemToFavUseCase.addItemToFav(storeItem)
        }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe()
    }

    fun deleteItemFromFav(storeItem: StoreItem){
        Completable.fromRunnable {
            deleteItemFromFavUseCase.deleteItemFromFav(storeItem.id)
        }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe()
    }
}
package com.example.farahstorekotlin.data.model

import androidx.databinding.ObservableBoolean
import com.google.gson.annotations.SerializedName

data class StoreItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    var itemName: String,
    @SerializedName("price")
    var itemPrice: Double,
    @SerializedName("image")
    var imageUrl: String,
){
    fun getItemPriceAsString(): String = itemPrice.toString()
}

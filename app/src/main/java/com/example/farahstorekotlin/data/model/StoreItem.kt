package com.example.farahstorekotlin.data.model

import com.google.gson.annotations.SerializedName

data class StoreItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    var itemName: String,
    @SerializedName("price")
    var itemPrice: Double
){
    fun getItemPriceAsString(): String = itemPrice.toString()
}

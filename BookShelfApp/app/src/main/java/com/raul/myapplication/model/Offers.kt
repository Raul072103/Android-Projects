package com.raul.myapplication.model

import kotlinx.serialization.Serializable

@Serializable
data class Offers(
    val finskyOfferType: Int,
    val listPrice: Price,
    val retailPrice: Price
)

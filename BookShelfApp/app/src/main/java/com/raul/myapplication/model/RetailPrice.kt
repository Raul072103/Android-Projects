package com.raul.myapplication.model

import kotlinx.serialization.Serializable

@Serializable
data class RetailPrice(
    val amount: Double,
    val currencyCode: String
)
package com.raul.myapplication.model

import kotlinx.serialization.Serializable

@Serializable
data class ListPrice(
    val amount: Double,
    val currencyCode: String
)

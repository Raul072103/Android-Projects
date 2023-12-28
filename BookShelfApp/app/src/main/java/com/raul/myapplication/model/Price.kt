package com.raul.myapplication.model

import kotlinx.serialization.Serializable

@Serializable
data class Price(
    val amountInMicros: Int,
    val currencyCode: String
)

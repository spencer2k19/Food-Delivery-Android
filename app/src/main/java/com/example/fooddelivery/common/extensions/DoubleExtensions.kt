package com.example.fooddelivery.common.extensions

fun Double.toPriceString(): String {
    return String.format("%.2f", this)
}
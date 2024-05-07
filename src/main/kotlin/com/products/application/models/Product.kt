package com.products.application.models

class Product(val id: String, var name: String, var value: Float, var quantity: Int?) {

    fun modifyProduct(name: String, value: Float, quantity: Int?) {
        this.name = name
        this.value = value
        this.quantity = quantity
    }

}
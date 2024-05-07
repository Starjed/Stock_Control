package com.products.application.models

class Stock(var products: ArrayList<Product>) {

    fun register(id: String, name: String, value: Float, quantity: Int) {
        products.add(Product(id, name, value, quantity))
    }

    fun modifyProduct(id: String, name: String, value: Float, quantity: Int) {
        val existingProduct = products.find { it.id == id }
        if (existingProduct != null) {
            existingProduct.name = name
            existingProduct.value = value
            existingProduct.quantity = quantity
        }
    }

    fun listProducts(): List<Product> {
        return this.products
    }
}

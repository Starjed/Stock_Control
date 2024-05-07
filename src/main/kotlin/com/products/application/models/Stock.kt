package com.products.application.models

class Stock(var products: ArrayList<Product>) {

    fun register(id: String, name: String, value: Float, quantity: Int) {
        products.add(Product(id, name, value, quantity))
    }

    fun listProducts(): List<Product> {
        return this.products
    }

    fun removeProduct(id: String) {
        val productBeRemoved = products.find { it.id === id }

        if (productBeRemoved == null)
            throw Exception("Product with id $id not found")

        products.remove(productBeRemoved)
    }
}

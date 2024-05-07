package com.products.application.models

import org.junit.jupiter.api.Test

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*

class StockTest {

    val productList = ArrayList<Product>()

    val stock = Stock(productList)

    fun fillStock() {
        stock.register("1", "Shoes", 60F, 1)
        stock.register("2", "T-Shirt", 30F, 1)
    }


    @Test
    fun `should register a product and save it in the stock list`() {
        fillStock()

        assertEquals(2, stock.products.size)
        assertThat(stock.products.find { it.id === "1" }!!.name).isEqualTo("Shoes")
        assertThat(stock.products.find { it.id === "2" }!!.value).isEqualTo(30F)
        assertThat(stock.products).hasSize(2)
    }

    @Test
    fun `should list all products in stock list`() {
        fillStock()
        assertThat(stock.listProducts()).hasSize(2)
    }

    @Test
    fun `should remove an product from the stock list`() {
        fillStock()
        val findProduct = stock.listProducts().find { it.id === "1" }!!

        stock.removeProduct(findProduct.id)

        assertThat(stock.products).hasSize(1)
        assertThat(stock.products).doesNotContain(findProduct)
    }

    @Test
    fun `should modify an existing product and save it in the stock list`() {
        fillStock()

        val findProduct = stock.listProducts().find { it.id === "1" }!!
        findProduct.modifyProduct("Hat", 15F, 10)

        assertThat(stock.products).hasSize(2)
        assertThat(stock.products.find { it.id === "1" }!!.name).isEqualTo("Hat")
    }
}
package com.products.application.models

import org.junit.jupiter.api.Test

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*

class StockTest {

    val productList = ArrayList<Product>()

    val stock = Stock(productList)

    @Test
    fun `should register a product and save it in the stock list`() {
        stock.register("1", "Shoes", 60F, 1)
        stock.register("2", "T-Shirt", 30F, 1)

        assertEquals(2, stock.products.size)
        assertThat(stock.products.find { it.id === "1" }!!.name).isEqualTo("Shoes")
        assertThat(stock.products.find { it.id === "2" }!!.value).isEqualTo(30F)
        assertThat(stock.products).hasSize(2)
    }

    @Test
    fun `should list all products in stock list`() {
        stock.register("1", "Shoes", 60F, 1)
        stock.register("2", "T-Shirt", 30F, 1)

        assertThat(stock.listProducts()).hasSize(2)
    }
}
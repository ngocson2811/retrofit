package com.example.retrofit

class ProductRepository {
    suspend fun getProducts(): List<Product> {
        return RetrofitInstance.api.getProducts()





    }
}
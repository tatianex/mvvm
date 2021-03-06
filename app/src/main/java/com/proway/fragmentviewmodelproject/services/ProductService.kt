package com.proway.fragmentviewmodelproject.services

import com.proway.fragmentviewmodelproject.model.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

    @GET("/products")
    fun getProducts(): Call<List<Product>>

    @GET("/products/{id}")
    fun getProduct(@Path("id") productId: Int): Call<Product>
}
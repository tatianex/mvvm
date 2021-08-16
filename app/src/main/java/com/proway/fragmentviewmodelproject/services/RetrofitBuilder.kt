package com.proway.fragmentviewmodelproject.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://fakestoreapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getProductService() : ProductService {
        return retrofit.create(ProductService::class.java)
    }


}
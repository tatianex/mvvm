package com.proway.fragmentviewmodelproject.repository

import com.proway.fragmentviewmodelproject.model.Product
import com.proway.fragmentviewmodelproject.services.RetrofitBuilder
import retrofit2.Callback

class ProductRepository {

    private val service = RetrofitBuilder.getProductService()

    fun getProducts(callBack: Callback<List<Product>>) {
        val call = service.getProducts()
        call.enqueue(callBack)
    }
}
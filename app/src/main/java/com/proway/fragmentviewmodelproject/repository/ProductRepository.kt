package com.proway.fragmentviewmodelproject.repository

import com.proway.fragmentviewmodelproject.model.Product
import com.proway.fragmentviewmodelproject.services.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepository {

    private val service = RetrofitBuilder.getProductService()

    fun getProducts(callback: (List<Product>?, String?) -> Unit) {
        val call = service.getProducts()
        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                response.body()?.let {
                    callback(it, null)
                }
                if (response.code() != 200) {
                    callback(null, "Sorry we couldn't find any product")
                }
            }
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                callback(null, t.localizedMessage)
            }
        })
    }

//    fun getProducts(callBack: Callback<List<Product>>) {
//        val call = service.getProducts()
//        call.enqueue(callBack)
//    }
}
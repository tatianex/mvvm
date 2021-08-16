package com.proway.fragmentviewmodelproject.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proway.fragmentviewmodelproject.model.Product
import com.proway.fragmentviewmodelproject.repository.ProductRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel(), Callback<List<Product>> {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    private val repository = ProductRepository()

    fun fetchProducts() {
        repository.getProducts(this)
    }

    override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
        response.body()?.apply {
            _products.value = this
        }
    }

    override fun onFailure(call: Call<List<Product>>, t: Throwable) {

    }

}
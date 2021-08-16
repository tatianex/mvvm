package com.proway.fragmentviewmodelproject.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proway.fragmentviewmodelproject.model.Product
import com.proway.fragmentviewmodelproject.repository.ProductRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val repository = ProductRepository()

    fun fetchProducts() {
        repository.getProducts { list, error ->
            list?.apply {
                _products.value = this
            }
            error?.apply {
                _error.value = this
            }
        }
    }

//    override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
//        response.body()?.apply {
//            _products.value = this
//        }
//    }
//
//    override fun onFailure(call: Call<List<Product>>, t: Throwable) {
//
//    }

}
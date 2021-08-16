package com.proway.fragmentviewmodelproject.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.proway.fragmentviewmodelproject.R
import com.proway.fragmentviewmodelproject.adapter.ProductAdapter
import com.proway.fragmentviewmodelproject.model.Product
import com.proway.fragmentviewmodelproject.view_model.MainViewModel

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var productRecyclerView: RecyclerView
    private val adapter = ProductAdapter {

    }

    private val productObserver = Observer<List<Product>> { newList ->
        adapter.update(newList)
    }

    private val errorObserver = Observer<String> { error ->
        Snackbar.make(requireView(), error, Snackbar.LENGTH_LONG).show()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productRecyclerView = view.findViewById(R.id.productRecyclerView)
        productRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        productRecyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.products.observe(viewLifecycleOwner, productObserver)
        viewModel.error.observe(viewLifecycleOwner, errorObserver)

        viewModel.fetchProducts()
    }

}
package com.example.retrofit

import com.example.retrofit.ProductAdapter
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductFragment : Fragment(R.layout.fragment_product) {

    private lateinit var viewModel: ProductViewModel
    private lateinit var adapter: ProductAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)





        viewModel = ViewModelProvider(this)[ProductViewModel::class.java]

        adapter = ProductAdapter()

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        viewModel.products.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }

        viewModel.loadProducts()
    }
}
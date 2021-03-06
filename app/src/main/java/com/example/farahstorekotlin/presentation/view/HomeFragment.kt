package com.example.farahstorekotlin.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.farahstorekotlin.R
import com.example.farahstorekotlin.databinding.FragmentHomeBinding
import com.example.farahstorekotlin.presentation.view.adapter.StoreItemAdapter
import com.example.farahstorekotlin.presentation.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: Fragment(R.layout.fragment_home) {

    private val mViewModel: HomeViewModel by viewModels()
    private lateinit var mBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.homeViewModel = mViewModel

        initRecycler()
    }

    private fun initRecycler() {
        val adapter = StoreItemAdapter(viewModel = mViewModel)
        mBinding.recyclerViewHomeFragmentStoreItems.layoutManager = LinearLayoutManager(context)
        mViewModel.storeItems.observe(viewLifecycleOwner, {
            adapter.submitList(storeItems = it)
        })
        mBinding.recyclerViewHomeFragmentStoreItems.adapter = adapter
    }

}
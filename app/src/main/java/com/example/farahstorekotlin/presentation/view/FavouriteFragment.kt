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
import com.example.farahstorekotlin.databinding.FragmentFavouriteBinding
import com.example.farahstorekotlin.presentation.view.adapter.FavStoreItemAdapter
import com.example.farahstorekotlin.presentation.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouriteFragment: Fragment(R.layout.fragment_favourite) {

    private val mViewModel: HomeViewModel by viewModels()
    private lateinit var mBinding: FragmentFavouriteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_favourite, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.viewModel = mViewModel

        initRecycler()
    }

    private fun initRecycler() {
        val adapter = FavStoreItemAdapter(viewModel = mViewModel)
        mBinding.recyclerViewFavFragmentStoreItems.layoutManager = LinearLayoutManager(context)
        mViewModel.storeItems.observe(viewLifecycleOwner, {
            adapter.submitList(storeItems = it)
        })
        mBinding.recyclerViewFavFragmentStoreItems.adapter = adapter
    }
}
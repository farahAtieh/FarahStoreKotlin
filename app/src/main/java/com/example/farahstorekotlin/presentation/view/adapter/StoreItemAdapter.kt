package com.example.farahstorekotlin.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.farahstorekotlin.data.model.StoreItem
import com.example.farahstorekotlin.databinding.StoreItemBinding
import com.example.farahstorekotlin.presentation.viewModel.HomeViewModel

class StoreItemAdapter(private val viewModel: HomeViewModel):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val DIFF_CALLback = object : DiffUtil.ItemCallback<StoreItem>(){
        override fun areItemsTheSame(oldItem: StoreItem, newItem: StoreItem): Boolean =
             oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: StoreItem, newItem: StoreItem): Boolean =
            oldItem == newItem
    }

    private val differ = AsyncListDiffer(this, DIFF_CALLback)

    fun submitList(storeItems: List<StoreItem>){
        differ.submitList(storeItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = StoreItemBinding.inflate(layoutInflater, parent, false)
        return StoreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as StoreViewHolder).bind(viewModel, differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    class StoreViewHolder(private val mBinding: StoreItemBinding):
        RecyclerView.ViewHolder(mBinding.root){

            fun bind(viewModel: HomeViewModel, storeItem: StoreItem){
                mBinding.viewModel = viewModel
                mBinding.item = storeItem
            }
    }

}
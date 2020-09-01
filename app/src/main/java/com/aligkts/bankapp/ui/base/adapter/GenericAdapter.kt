package com.aligkts.bankapp.ui.base.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView

class GenericAdapter<T : BaseRecyclerviewItem>(@LayoutRes val layoutId: Int,
                                               val items: ArrayList<T>,
                                               val callback : (GenericViewHolder<T>, T)-> Unit) :
    RecyclerView.Adapter<GenericAdapter.GenericViewHolder<T>>() {

    private var inflater: LayoutInflater? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<T> {
        val layoutInflater = inflater ?: LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, layoutId, parent, false)
        return GenericViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: GenericViewHolder<T>, position: Int) {
        val itemViewModel = items[position]
        itemViewModel.adapterPosition = position
        holder.bind(itemViewModel)
        holder.itemView.setOnClickListener {
            callback.invoke(holder, items[position])
        }
    }


    class GenericViewHolder<T : BaseRecyclerviewItem>(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(itemViewModel: T) {
            binding.setVariable(BR.item, itemViewModel)
            binding.executePendingBindings()
        }

    }
}
package com.aligkts.bankapp.ui.base.adapter

abstract class BaseRecyclerviewItem{
    var adapterPosition: Int = -1
    var onListItemViewClickListener: GenericAdapter.OnListItemViewClickListener? = null
}
package com.aligkts.bankapp.ui.utils.extension

import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Ali Göktaş on 28,August,2020
 */

fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(adapterPosition, itemViewType)
    }
    return this
}
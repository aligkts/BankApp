package com.aligkts.bankapp.ui.utils.extension

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.aligkts.bankapp.R
import com.github.florent37.viewtooltip.ViewTooltip

/**
 * Created by Ali Göktaş on 28,August,2020
 */

fun <T : ViewDataBinding> ViewGroup?.inflate(@LayoutRes layoutId: Int, attachToParent: Boolean = true): T {
    return DataBindingUtil.inflate(LayoutInflater.from(this!!.context), layoutId, this, attachToParent)
}

fun View.showToolTip(message: String): ViewTooltip.TooltipView {
    return ViewTooltip.on(this)
        .autoHide(false, 0)
        .align(ViewTooltip.ALIGN.CENTER)
        .color(ContextCompat.getColor(context, R.color.colorPrimary))
        .textColor(ContextCompat.getColor(context, android.R.color.white))
        .text(message)
        .clickToHide(false)
        .position(ViewTooltip.Position.BOTTOM)
        .show()
}

fun <T : View> T.click(block: (T) -> Unit) = setOnClickListener { block(it as T) }

fun <T : View> T.longClick(block: (T) -> Boolean) = setOnLongClickListener { block(it as T) }

fun View.show() : View {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
    return this
}

fun View.hide() : View {
    if (visibility != View.INVISIBLE) {
        visibility = View.INVISIBLE
    }
    return this
}
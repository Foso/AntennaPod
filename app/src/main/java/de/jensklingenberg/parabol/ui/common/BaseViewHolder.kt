package de.jensklingenberg.parabol.ui.common

import android.content.Context
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BaseViewHolder<P : BaseDataSourceItem<*>>(viewParent: ViewGroup, @LayoutRes layoutId: Int) :
        RecyclerView.ViewHolder(
                LayoutInflater.from(viewParent.context).inflate(
                        layoutId,
                        viewParent,
                        false
                )
        ) {

    protected var context: Context = viewParent.context

    fun onBindViewHolderInternal(item: Any, payloads: List<Any>) {
        var diff = Bundle()
        if (payloads.isNotEmpty()) {
            diff = payloads[0] as Bundle
        }
        onBindViewHolder(item as P, diff)
    }

    abstract fun onBindViewHolder(sourceItem: P, diff: Bundle)


}

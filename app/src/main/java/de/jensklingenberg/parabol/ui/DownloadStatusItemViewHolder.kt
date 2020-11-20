package de.jensklingenberg.parabol.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import de.danoeh.antennapod.R
import de.danoeh.antennapod.core.service.download.DownloadStatus


import de.jensklingenberg.parabol.ui.common.BaseViewHolder


class DownloadStatusItemViewHolder(val viewParent: ViewGroup) :
        BaseViewHolder<DownloadStatusSourceItem>(viewParent, R.layout.downloadlog_item) {





    override fun onBindViewHolder(sourceItem: DownloadStatusSourceItem, diff: Bundle) {


        sourceItem.getPayload()?.let {
            val text = itemView.findViewById<TextView>(R.id.txtvTitle)
            text.text = it.title
        }






    }





    interface OnEntryClickListener {
        fun onItemClicked(payload: DownloadStatus)

    }

}

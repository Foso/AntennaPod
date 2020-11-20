package de.jensklingenberg.parabol.ui

import de.danoeh.antennapod.core.service.download.DownloadStatus

import de.jensklingenberg.parabol.ui.common.BaseDataSourceItem


class DownloadStatusSourceItem(
        feedItem: DownloadStatus, var onEntryClickListener: DownloadStatusItemViewHolder.OnEntryClickListener? = null
) :
        BaseDataSourceItem<DownloadStatus>(DownloadStatusItemViewHolder::class.java) {

    init {
        setPayload(feedItem)
    }


    override fun areItemsTheSameInner(other: BaseDataSourceItem<DownloadStatus>): Boolean {
        return false
    }

    override fun areContentsTheSameInner(other: BaseDataSourceItem<DownloadStatus>): Boolean {
        return false
    }


}

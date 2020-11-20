package de.jensklingenberg.parabol.ui

import de.danoeh.antennapod.core.feed.FeedItem
import de.jensklingenberg.parabol.ui.common.BaseDataSourceItem


class FeedSourceItem(
        feedItem: FeedItem, var onEntryClickListener: FeedItemViewHolder.OnEntryClickListener? = null
) :
        BaseDataSourceItem<FeedItem>(FeedItemViewHolder::class.java) {

    init {
        setPayload(feedItem)
    }


    override fun areItemsTheSameInner(other: BaseDataSourceItem<FeedItem>): Boolean {
        return false
    }

    override fun areContentsTheSameInner(other: BaseDataSourceItem<FeedItem>): Boolean {
        return false
    }


}

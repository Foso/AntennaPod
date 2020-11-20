package de.jensklingenberg.parabol.ui.subscriptions

import de.danoeh.antennapod.core.feed.Feed


import de.jensklingenberg.parabol.ui.common.BaseDataSourceItem


class SubscriptionSourceItem(
        feedItem: Feed, var onEntryClickListener: SubscriptionItemViewHolder.OnEntryClickListener? = null
) :
        BaseDataSourceItem<Feed>(SubscriptionItemViewHolder::class.java) {

    init {
        setPayload(feedItem)
    }


    override fun areItemsTheSameInner(other: BaseDataSourceItem<Feed>): Boolean {
        return false
    }

    override fun areContentsTheSameInner(other: BaseDataSourceItem<Feed>): Boolean {
        return false
    }


}

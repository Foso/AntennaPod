package de.jensklingenberg.parabol.ui.subscriptions

import android.util.Log
import de.danoeh.antennapod.core.feed.Feed
import de.jensklingenberg.parabol.data.FeedRepository



class SubscriptionsPresenter(val view: Contract.View) : Contract.Presenter, SubscriptionItemViewHolder.OnEntryClickListener {
    val feedDataSource = FeedRepository()

    override fun onInit() {

        view.setData(feedDataSource.getFeedList().map {
            SubscriptionSourceItem(it,onEntryClickListener = this)
        })
    }

    override fun onItemClicked(payload: Feed) {
        Log.d("XXX","HALLO")
        view.navigateTo(Contract.Destination.FeedItemlist(payload.id))
    }

    override fun shutdown() {

    }

    override fun performSearch(query: String, selectedFeed: Long) {
        val list = feedDataSource.getFeedList().filter { it.preferences.isFavorite }.filter { it.title.contains(query,true) }.map {
            SubscriptionSourceItem(it,onEntryClickListener = this)
        }
        Log.d("XXX","LIst"+list.size.toString())
        view.setData(list)
    }

}
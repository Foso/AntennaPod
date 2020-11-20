package de.jensklingenberg.parabol.ui

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import de.danoeh.antennapod.PodcastApp
import de.danoeh.antennapod.R
import de.danoeh.antennapod.core.feed.FeedItem
import de.danoeh.antennapod.core.storage.DownloadRequester
import de.danoeh.antennapod.core.util.Converter
import de.danoeh.antennapod.core.util.DateUtils
import de.jensklingenberg.parabol.ui.common.BaseViewHolder


class FeedItemViewHolder(viewParent: ViewGroup) :
        BaseViewHolder<FeedSourceItem>(viewParent, R.layout.episodes_listitem) {




    override fun onBindViewHolder(sourceItem: FeedSourceItem, diff: Bundle) {

        val feedItem = sourceItem.getPayload()

        feedItem?.let {

            itemView.apply {
                val text = itemView.findViewById<TextView>(R.id.txtvTitle)

                text.text = feedItem.title


            }
        }
    }


    interface OnEntryClickListener {
        fun onItemClicked(payload: FeedItem)

    }
}
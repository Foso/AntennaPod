package de.jensklingenberg.parabol.ui.episodes

import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.danoeh.antennapod.R
import de.danoeh.antennapod.core.feed.FeedItem
import de.danoeh.antennapod.core.glide.ApGlideSettings
import de.jensklingenberg.parabol.ui.common.BaseViewHolder


class FeedItemViewHolder(viewParent: ViewGroup) :
        BaseViewHolder<FeedItemSourceItem>(viewParent, R.layout.episodes_listitem) {




    override fun onBindViewHolder(sourceItem: FeedItemSourceItem, diff: Bundle) {

        val feedItem = sourceItem.getPayload()

        feedItem?.let {

            itemView.apply {
                val text = itemView.findViewById<TextView>(R.id.txtvTitle)

                text.text = feedItem.title


                val txtvDuration = itemView.findViewById<TextView>(R.id.txtvDuration)
                txtvDuration.text = feedItem.feed.title
                val icon = this.findViewById<ImageView>(R.id.imgvCover)

                Glide.with(context)
                        .load(it.imageLocation)
                        .apply(RequestOptions()
                                .placeholder(R.color.light_gray)
                                .error(R.color.light_gray)
                                .diskCacheStrategy(ApGlideSettings.AP_DISK_CACHE_STRATEGY)
                                .fitCenter()
                                .dontAnimate())
                        .into(icon)

            }
        }
    }


    interface OnEntryClickListener {
        fun onItemClicked(payload: FeedItem)

    }
}
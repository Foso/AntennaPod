package de.jensklingenberg.parabol.ui.subscriptions

import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.joanzapata.iconify.widget.IconTextView
import de.danoeh.antennapod.R
import de.danoeh.antennapod.core.feed.Feed
import de.danoeh.antennapod.core.glide.ApGlideSettings
import de.danoeh.antennapod.view.SquareImageView
import de.jensklingenberg.parabol.ui.common.BaseViewHolder


class SubscriptionItemViewHolder(viewParent: ViewGroup) :
        BaseViewHolder<SubscriptionSourceItem>(viewParent, R.layout.episodes_listitem) {


    override fun onBindViewHolder(sourceItem: SubscriptionSourceItem, diff: Bundle) {

        val feed = sourceItem.getPayload()

        feed?.let {

            itemView.apply {
                findViewById<TextView>(R.id.txtvTitle).text = feed.title
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

                setOnClickListener {
                    sourceItem.onEntryClickListener?.onItemClicked(feed)
                }
            }
        }
    }


    interface OnEntryClickListener {
        fun onItemClicked(payload: Feed)

    }
}
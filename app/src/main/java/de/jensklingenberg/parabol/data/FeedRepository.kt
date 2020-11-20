package de.jensklingenberg.parabol.data

import de.danoeh.antennapod.core.feed.Feed
import de.danoeh.antennapod.core.feed.FeedItem
import de.danoeh.antennapod.core.storage.DBReader

interface FeedDataSource{

    /**
     * Loads a list of FeedItems sorted by pubDate in descending order.
     *
     * @param limit The maximum number of episodes that should be loaded.
     */
    fun getRecentlyPublishedEpisodes(offset:Int,limit:Int): List<FeedItem>
}

class FeedRepository :FeedDataSource{
    override fun getRecentlyPublishedEpisodes(offset: Int, limit: Int): List<FeedItem> {
       return DBReader.getRecentlyPublishedEpisodes(0, limit)
    }

}
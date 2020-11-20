package de.jensklingenberg.parabol.ui

import de.jensklingenberg.parabol.data.FeedRepository
import de.jensklingenberg.parabol.ui.common.BaseDataSourceItem

interface Contract {
    interface Presenter {
        fun onInit()
        fun shutdown()
    }

    interface View {
        fun setData(list: List<BaseDataSourceItem<*>>)

    }
}

class MyPresenter(val view: Contract.View) : Contract.Presenter {
    val feedDataSource = FeedRepository()

    protected val EPISODES_PER_PAGE = 150
    protected var page = 1


    override fun onInit() {

        view.setData(feedDataSource.getRecentlyPublishedEpisodes(0, page * EPISODES_PER_PAGE).map {
            FeedSourceItem(it)
        })
    }

    override fun shutdown() {

    }


}
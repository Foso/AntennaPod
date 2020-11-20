package de.jensklingenberg.parabol.ui.subscriptions

import de.jensklingenberg.parabol.ui.common.BaseDataSourceItem

interface NavigatorView<T> {
    fun navigateTo(destination: T)
}


interface Contract {
    interface Presenter {
        fun onInit()
        fun shutdown()
    }

    interface View : NavigatorView<Destination> {
        fun setData(list: List<BaseDataSourceItem<*>>)

    }

    sealed class Destination {
        class FeedItemlist(val feedId: Long) : Destination()
    }
}
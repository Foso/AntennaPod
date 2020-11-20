package de.jensklingenberg.parabol.ui.subscriptions


import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import de.danoeh.antennapod.R
import de.danoeh.antennapod.activity.MainActivity
import de.danoeh.antennapod.databinding.JkFragmentSubscriptionsBinding
import de.danoeh.antennapod.fragment.FeedItemlistFragment
import de.jensklingenberg.parabol.ui.common.BaseAdapter
import de.jensklingenberg.parabol.ui.common.BaseDataSourceItem

class MySubscriptionsFragment : Fragment(), Contract.View {

    val presenter: Contract.Presenter by lazy { SubscriptionsPresenter(this) }
    private val baseAdapter = BaseAdapter()
    lateinit var binding: JkFragmentSubscriptionsBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = JkFragmentSubscriptionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
        toolbar.setTitle(R.string.subscriptions_label)
        toolbar.inflateMenu(R.menu.episodes)
        de.danoeh.antennapod.menuhandler.MenuItemUtils.setupSearchItem(toolbar.menu, activity as MainActivity?, 0, "")
        setupSearch(toolbar)

        setupRecyclerView()
        presenter.onInit()
    }

    private fun setupSearch(toolbar: Toolbar) {
        val searchItem = toolbar.menu.findItem(R.id.action_search)

        val sv = MenuItemCompat.getActionView(searchItem) as SearchView

        sv.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                sv.clearFocus()

                return true
            }

            override fun onQueryTextChange(s: String): Boolean {
                Log.d("XXX", s)
                presenter.performSearch(s)
                if (s.isEmpty()) {
                    // presenter.loadDownloadLog()
                }
                return false
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu?.clear()
        inflater?.inflate(R.menu.episodes, menu)

    }

    private fun setupRecyclerView() {

        binding.recyclerView.apply {

            adapter = baseAdapter

            layoutManager = LinearLayoutManager(context)

            addItemDecoration(
                    DividerItemDecoration(
                            requireContext(),
                            DividerItemDecoration.VERTICAL
                    )
            )
        }
    }

    override fun setData(list: List<BaseDataSourceItem<*>>) {
        baseAdapter.dataSource.setItems(list)
        baseAdapter.notifyDataSetChanged()
    }

    override fun navigateTo(destination: Contract.Destination) {
        when (destination) {
            is Contract.Destination.FeedItemlist -> {
                val fragment: Fragment = FeedItemlistFragment.newInstance(destination.feedId)
                (requireActivity() as MainActivity).loadChildFragment(fragment)
            }
        }

    }


    companion object {

        const val TAG = "SubscriptionsFragment"
    }
}
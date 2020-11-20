package de.jensklingenberg.parabol.ui.subscriptions


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        val toolbar: androidx.appcompat.widget.Toolbar = view.findViewById(R.id.toolbar)
        toolbar.setTitle(R.string.playback_history_label)


        setupRecyclerView()
        presenter.onInit()
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
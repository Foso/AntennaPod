package de.jensklingenberg.parabol.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import de.danoeh.antennapod.R
import de.danoeh.antennapod.databinding.JkFragmentEpisodesBinding
import de.jensklingenberg.parabol.ui.common.BaseAdapter


import de.jensklingenberg.parabol.ui.common.BaseDataSourceItem

class MyEpisodesFragment : Fragment(), Contract.View {

    val presenter: Contract.Presenter by lazy { MyPresenter(this) }
    private val baseAdapter = BaseAdapter()

    private var _binding: JkFragmentEpisodesBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    companion object {

        const val TAG = "MyEpisodesFragment"
    }


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = JkFragmentEpisodesBinding.inflate(inflater, container, false)
        return binding.root
    }





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar: androidx.appcompat.widget.Toolbar = view.findViewById(R.id.toolbar)
        toolbar.setTitle(R.string.playback_history_label)
        //toolbar.setOnMenuItemClickListener(this)

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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
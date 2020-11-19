package de.jensklingenberg.parabol.ui

import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import de.danoeh.antennapod.R

class MyEpisodesFragment : Fragment(R.layout.jk_fragment_episodes){
    companion object{

        const val TAG = "MyEpisodesFragment"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar : androidx.appcompat.widget.Toolbar = view.findViewById(R.id.toolbar)
        toolbar.setTitle(R.string.playback_history_label)
        //toolbar.setOnMenuItemClickListener(this)
    }
}
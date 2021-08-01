package uk.co.imobilize.lastfmsampleapp.android.home.artists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.core.component.KoinComponent
import uk.co.imobilize.lastfmsampleapp.android.R
import uk.co.imobilize.lastfmsampleapp.android.databinding.FragmentArtistsBinding
import uk.co.imobilize.lastfmsampleapp.models.Artist


class ArtistsFragment(val artists: List<Artist>): Fragment(R.layout.fragment_artists), KoinComponent {

    var binding: FragmentArtistsBinding? = null
    lateinit var adapter: ArtistListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArtistsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ArtistListAdapter()
        adapter.artistList = artists

        val layoutManager = LinearLayoutManager(binding!!.root.context)

        binding?.recyclerUserView?.adapter = adapter
        binding?.recyclerUserView?.layoutManager = layoutManager
        binding?.recyclerUserView?.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL)
        )
    }
}
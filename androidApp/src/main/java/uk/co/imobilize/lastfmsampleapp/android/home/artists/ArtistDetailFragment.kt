package uk.co.imobilize.lastfmsampleapp.android.home.artists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import org.koin.core.component.KoinComponent
import uk.co.imobilize.lastfmsampleapp.android.R
import uk.co.imobilize.lastfmsampleapp.android.databinding.FragmentArtistDetailBinding
import uk.co.imobilize.lastfmsampleapp.models.Artist

class ArtistDetailFragment(val artist: Artist): Fragment(R.layout.fragment_artist_detail), KoinComponent {

    private lateinit var binding: FragmentArtistDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArtistDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            artist.apply {

                artistNameLabel.text = name
                urlTextLabel.text = url
                listenersTextLabel.text = listeners
                idTextLabel.text = id

                if(imageUrl.isNotEmpty()) {
                    Picasso.get().load(imageUrl).into(artistImageView as ImageView)
                }
            }
        }
    }
}
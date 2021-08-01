package uk.co.imobilize.lastfmsampleapp.android.home.artists

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uk.co.imobilize.lastfmsampleapp.android.databinding.LayoutArtistListItemBinding
import uk.co.imobilize.lastfmsampleapp.models.Artist

interface ArtistClickListener {
    fun onArtistClick(artist: Artist)
}

class ArtistListAdapter(val artistListClickListener: ArtistClickListener) : RecyclerView.Adapter<ArtistListAdapter.UsersListViewHolder>() {

    var artistList: List<Artist> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersListViewHolder {

        val binding = LayoutArtistListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return UsersListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersListViewHolder, position: Int) {

        with(holder) {

            with(artistList[position]) {

                binding.textName.text = name

                if(thumbnailUrl.isNotEmpty()) {
                    Picasso.get().load(thumbnailUrl).into(binding.imageUser as ImageView)
                }

                binding.root.setOnClickListener {

                    artistListClickListener.onArtistClick(this)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

    inner class UsersListViewHolder(val binding: LayoutArtistListItemBinding) : RecyclerView.ViewHolder(binding.root) {}
}

package uk.co.imobilize.lastfmsampleapp.controllers

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import uk.co.imobilize.lastfmsampleapp.models.Artist
import uk.co.imobilize.lastfmsampleapp.repositories.SearchRepository
import uk.co.imobilize.lastfmsampleapp.repositories.SearchRepositoryState

class SearchControllerImpl: SearchController, KoinComponent {

    private val searchRepository: SearchRepository by inject()

    override var delegate: EventsControllerDelegate? = null
    override var coroutineScope: CoroutineScope = MainScope()

    override fun searchArtists(artistName: String) {

        coroutineScope.launch {

            val stateFlow = searchRepository.searchArtist(artistName)

            stateFlow.collect { state ->

                when (state) {
                    is SearchRepositoryState.Loading -> {
                        delegate?.stateUpdated(SearchControllerState.Loading)
                    }
                    is SearchRepositoryState.Failed -> {
                        delegate?.stateUpdated(SearchControllerState.Failed(state.message))
                    }
                    is SearchRepositoryState.Success -> {

                        val artists = state.searchResults["artists"] as? List<Map<String, Any>>

                        val artistList = artists?.mapNotNull {

                            val name = it["name"] as? String ?: "Unknown"
                            val thumbnail = it["image_small"] as? String ?: ""
                            val id = it["mbid"] as? String ?: return@mapNotNull null

                            Artist(id, name, thumbnail)
                        } ?: emptyList()

                        delegate?.stateUpdated(SearchControllerState.ShowArtists(artistList))
                    }
                }

            }
        }
    }
}
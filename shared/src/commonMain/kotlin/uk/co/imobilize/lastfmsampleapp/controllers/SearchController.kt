package uk.co.imobilize.lastfmsampleapp.controllers

import kotlinx.coroutines.CoroutineScope
import uk.co.imobilize.lastfmsampleapp.models.Artist


sealed class SearchControllerState {
    class ShowArtists(val artists: List<Artist>): SearchControllerState()
    object Loading : SearchControllerState()
    class Failed(val message: String) : SearchControllerState()
}

interface EventsControllerDelegate {
    fun stateUpdated(updatedState: SearchControllerState)
}

interface SearchController {

    var delegate: EventsControllerDelegate?
    var coroutineScope: CoroutineScope

    fun searchArtists(artistName: String)
}
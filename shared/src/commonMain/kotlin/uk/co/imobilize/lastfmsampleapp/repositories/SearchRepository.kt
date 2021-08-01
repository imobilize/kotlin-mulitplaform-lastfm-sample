package uk.co.imobilize.lastfmsampleapp.repositories

import kotlinx.coroutines.flow.Flow

sealed class SearchRepositoryState {
    object Loading: SearchRepositoryState()
    class Success(val searchResults: Map<String, Any>) : SearchRepositoryState()
    class Failed(val message: String) : SearchRepositoryState()
}

interface SearchRepository {

    fun searchArtist(artistName: String): Flow<SearchRepositoryState>
    fun searchAlbum(artistName: String): Flow<SearchRepositoryState>
    fun searchATrack(artistName: String): Flow<SearchRepositoryState>
}
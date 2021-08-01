package uk.co.imobilize.lastfmsampleapp.repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uk.co.imobilize.lastfmsampleapp.services.api.SearchAPI
import uk.co.imobilize.lastfmsampleapp.utils.ConsoleLogger

class SearchRepositoryImpl(
    private val searchAPI: SearchAPI,
    private val logger: ConsoleLogger): SearchRepository {

    override fun searchArtist(artistName: String) = flow {

        logger.debug("Fetching artist with name: $artistName from search API")

        emit(SearchRepositoryState.Loading)

        val response = searchAPI.searchArtist(artistName)

        if (response["artists"] == null) {
            emit(SearchRepositoryState.Failed("Could not fetch artist from API"))
        } else {
            emit(SearchRepositoryState.Success(response))
        }
    }

    override fun searchAlbum(artistName: String): Flow<SearchRepositoryState> {
        TODO("Not yet implemented")
    }

    override fun searchATrack(artistName: String): Flow<SearchRepositoryState> {
        TODO("Not yet implemented")
    }
}
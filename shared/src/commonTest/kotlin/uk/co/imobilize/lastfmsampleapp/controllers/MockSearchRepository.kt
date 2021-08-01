package uk.co.imobilize.lastfmsampleapp.controllers

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uk.co.imobilize.lastfmsampleapp.repositories.SearchRepository
import uk.co.imobilize.lastfmsampleapp.repositories.SearchRepositoryState

class MockSearchRepository: SearchRepository {

    lateinit var stateToEmit: SearchRepositoryState

    override suspend fun searchArtist(artistName: String) = flow {
       emit(stateToEmit)
    }

    override suspend fun searchAlbum(artistName: String): Flow<SearchRepositoryState> {
        TODO("Not yet implemented")
    }

    override suspend fun searchATrack(artistName: String): Flow<SearchRepositoryState> {
        TODO("Not yet implemented")
    }

}

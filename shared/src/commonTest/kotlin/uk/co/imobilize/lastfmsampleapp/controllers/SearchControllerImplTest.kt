package uk.co.imobilize.lastfmsampleapp.controllers

import com.indexlabs.kmm_frontend.utils.joinChildren
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.mock.declare
import uk.co.imobilize.lastfmsampleapp.repositories.SearchRepository
import uk.co.imobilize.lastfmsampleapp.repositories.SearchRepositoryState
import uk.co.imobilize.lastfmsampleapp.utils.runTest
import kotlin.test.*

class SearchControllerImplTest : EventsControllerDelegate, KoinTest {

    lateinit var mockSearchRepository: MockSearchRepository
    var stateList = mutableListOf<SearchControllerState>()

    lateinit var searchController: SearchController


    @BeforeTest
    fun setUp() {

        startKoin { }

        mockSearchRepository = MockSearchRepository()

        declare<SearchRepository> {
            mockSearchRepository
        }

        searchController = SearchControllerImpl()
        searchController.delegate = this
    }

    @AfterTest
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun searchArtistLoadingState() = runTest {

        searchController.coroutineScope = this

        mockSearchRepository.stateToEmit = SearchRepositoryState.Loading
        searchController.searchArtists("Cher")

        joinChildren()

        val state = stateList.first()
        assertEquals(state, SearchControllerState.Loading)
    }

    @Test
    fun searchArtistShowsArtists() = runTest {

        searchController.coroutineScope = this

        val artistList = listOf(mapOf("name" to "Cher", "mbid" to "1234"), mapOf("name" to "Ed Sheeran", "mbid" to "4321"))
        val responseMap = mapOf("artists" to artistList)

        mockSearchRepository.stateToEmit = SearchRepositoryState.Success(responseMap)
        searchController.searchArtists("Cher")

        joinChildren()

        val state = stateList.last()

        val correctState = (state is SearchControllerState.ShowArtists)
        assertTrue(correctState)

        state as SearchControllerState.ShowArtists
        assertEquals(state.artists.first().name, "Cher")
    }

    override fun stateUpdated(updatedState: SearchControllerState) {
        stateList.add(updatedState)
    }
}
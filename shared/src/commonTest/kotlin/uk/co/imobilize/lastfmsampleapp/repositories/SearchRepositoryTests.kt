package uk.co.imobilize.lastfmsampleapp.repositories

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import uk.co.imobilize.lastfmsampleapp.utils.MockConsoleLogger
import uk.co.imobilize.lastfmsampleapp.utils.runTest
import kotlin.test.*

class SearchRepositoryTests {

    lateinit var mockLogger: MockConsoleLogger
    lateinit var mockSearchAPI: MockSearchAPI

    lateinit var searchRepository: SearchRepository

    @BeforeTest
    fun setUp() {

        mockLogger = MockConsoleLogger()
        mockSearchAPI = MockSearchAPI()

        searchRepository = SearchRepositoryImpl(mockSearchAPI, mockLogger)
    }

    @Test
    fun searchArtistReturnsLoading() = runTest {

        val respositoryStateFlow = searchRepository.searchArtist("Cher")

        val initialState = respositoryStateFlow.first()
        assertEquals(initialState, SearchRepositoryState.Loading)
    }

    @Test
    fun searchArtistReturnsSuccess() = runTest {

        val artistList = listOf(mapOf("name" to "Cher"), mapOf("name" to "Ed Sheeran"))
        val responseMap = mapOf("artists" to artistList)

        mockSearchAPI.artistsToReturn = responseMap

        val respositoryStateFlow = searchRepository.searchArtist("Cher")

        val lastState = respositoryStateFlow.last()

        val correctState = (lastState is SearchRepositoryState.Success)
        assertTrue(correctState)

        lastState as SearchRepositoryState.Success
        assertNotNull(lastState.searchResults.get("artists"))
    }
}
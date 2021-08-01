package uk.co.imobilize.lastfmsampleapp.services.api

interface SearchAPI {

    suspend fun searchArtist(artistName: String): Map<String, Any>
    suspend fun searchAlbum(albumName: String): Map<String, Any>
    suspend fun searchTrack(trackName: String): Map<String, Any>
}
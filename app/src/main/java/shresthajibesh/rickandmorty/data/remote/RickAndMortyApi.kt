package shresthajibesh.rickandmorty.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import shresthajibesh.rickandmorty.data.remote.models.CharacterDTO
import shresthajibesh.rickandmorty.data.remote.models.CharactersDTO
import shresthajibesh.rickandmorty.data.remote.models.EpisodeDTO
import shresthajibesh.rickandmorty.data.remote.models.EpisodesDTO
import shresthajibesh.rickandmorty.data.remote.models.LocationDTO
import shresthajibesh.rickandmorty.data.remote.models.LocationsDTO

interface RickAndMortyApi {

    @GET("character/")
    suspend fun getCharacters(): CharactersDTO

    @GET("character/{id}")
    suspend fun getCharacterDetails(
        @Path("id") id: Int
    ): CharacterDTO

    @GET("location/")
    suspend fun getLocations(): LocationsDTO

    @GET("location/{id}")
    suspend fun getLocationDetails(
        @Path("id") id: Int
    ): LocationDTO

    @GET("episode/")
    suspend fun getEpisodes(): EpisodesDTO

    @GET("episode/{id}")
    suspend fun getEpisodeDetails(
        @Path("id") id: Int
    ): EpisodeDTO

}
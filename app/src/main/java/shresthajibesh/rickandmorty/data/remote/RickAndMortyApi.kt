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
    fun getCharacters(): CharactersDTO

    @GET("character/{id}")
    fun getCharacterDetails(
        @Path("id") id: Int
    ): CharacterDTO

    @GET("location/")
    fun getLocations(): LocationsDTO

    @GET("location/{id}")
    fun getLocationDetails(
        @Path("id") id: Int
    ): LocationDTO

    @GET("episode/")
    fun getEpisodes(): EpisodesDTO

    @GET("episode/{id}")
    fun getEpisodeDetails(
        @Path("id") id: Int
    ): EpisodeDTO

}
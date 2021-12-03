package shresthajibesh.rickandmorty.domain.repository

import kotlinx.coroutines.flow.Flow
import shresthajibesh.rickandmorty.common.Async
import shresthajibesh.rickandmorty.domain.model.Character
import shresthajibesh.rickandmorty.domain.model.CharacterDetails
import shresthajibesh.rickandmorty.domain.model.Episode
import shresthajibesh.rickandmorty.domain.model.EpisodeDetails
import shresthajibesh.rickandmorty.domain.model.Location
import shresthajibesh.rickandmorty.domain.model.LocationDetails

interface RickAndMortyRepository {
    suspend fun getCharacters():List<Character>
    suspend fun getCharacterDetails(id:Int):CharacterDetails
    suspend fun getLocations():List<Location>
    suspend fun getLocationDetails(id:Int):LocationDetails
    suspend fun getEpisodes():List<Episode>
    suspend fun getEpisodeDetails(id:Int):EpisodeDetails
}
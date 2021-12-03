package shresthajibesh.rickandmorty.data.repository

import shresthajibesh.rickandmorty.data.remote.RickAndMortyApi
import shresthajibesh.rickandmorty.domain.model.Character
import shresthajibesh.rickandmorty.domain.model.CharacterDetails
import shresthajibesh.rickandmorty.domain.model.Episode
import shresthajibesh.rickandmorty.domain.model.EpisodeDetails
import shresthajibesh.rickandmorty.domain.model.Location
import shresthajibesh.rickandmorty.domain.model.LocationDetails
import shresthajibesh.rickandmorty.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class RickAndMortyRepositoryImpl
@Inject constructor(private val api: RickAndMortyApi) : RickAndMortyRepository {

    override suspend fun getCharacters(): List<Character> {
        return api.getCharacters().results.map { it.toCharacter() }
    }

    override suspend fun getCharacterDetails(id: Int): CharacterDetails {
        return api.getCharacterDetails(id).toCharacterDetails()
    }

    override suspend fun getLocations(): List<Location> {
        return api.getLocations().results.map { it.toLocation() }
    }

    override suspend fun getLocationDetails(id: Int): LocationDetails {
        return api.getLocationDetails(id).toLocationDetails()
    }

    override suspend fun getEpisodes(): List<Episode> {
        return api.getEpisodes().results.map { it.toEpisode() }
    }

    override suspend fun getEpisodeDetails(id: Int): EpisodeDetails {
        return api.getEpisodeDetails(id).toEpisodeDetails()
    }
}
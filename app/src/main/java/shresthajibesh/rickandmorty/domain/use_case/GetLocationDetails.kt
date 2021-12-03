package shresthajibesh.rickandmorty.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import shresthajibesh.rickandmorty.common.Async
import shresthajibesh.rickandmorty.common.Failure
import shresthajibesh.rickandmorty.common.Loading
import shresthajibesh.rickandmorty.common.Success
import shresthajibesh.rickandmorty.domain.model.CharacterDetails
import shresthajibesh.rickandmorty.domain.model.LocationDetails
import shresthajibesh.rickandmorty.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class GetLocationDetails@Inject constructor(private val repo: RickAndMortyRepository) {
    suspend operator fun invoke(id: Int): Flow<Async<LocationDetails>> = flow {
        emit(Loading<LocationDetails>())
        try {
            emit(Success(repo.getLocationDetails(id)))
        } catch (throwable: Throwable) {
            emit(Failure<LocationDetails>(throwable))
        }
    }
}
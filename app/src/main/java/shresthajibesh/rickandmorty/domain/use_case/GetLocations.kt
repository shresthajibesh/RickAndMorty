package shresthajibesh.rickandmorty.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import shresthajibesh.rickandmorty.common.Async
import shresthajibesh.rickandmorty.common.Failure
import shresthajibesh.rickandmorty.common.Loading
import shresthajibesh.rickandmorty.common.Success
import shresthajibesh.rickandmorty.domain.model.Location
import shresthajibesh.rickandmorty.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class GetLocations @Inject constructor(private val repo: RickAndMortyRepository) {
    suspend operator fun invoke(id: Int): Flow<Async<List<Location>>> = flow {
        emit(Loading<List<Location>>())
        try {
            emit(Success(repo.getLocations()))
        } catch (throwable: Throwable) {
            emit(Failure<List<Location>>(throwable))
        }
    }
}
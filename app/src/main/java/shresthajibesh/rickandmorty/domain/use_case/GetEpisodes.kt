package shresthajibesh.rickandmorty.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import shresthajibesh.rickandmorty.common.Async
import shresthajibesh.rickandmorty.common.Failure
import shresthajibesh.rickandmorty.common.Loading
import shresthajibesh.rickandmorty.common.Success
import shresthajibesh.rickandmorty.domain.model.Episode
import shresthajibesh.rickandmorty.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class GetEpisodes @Inject constructor(private val repo: RickAndMortyRepository) {
    suspend operator fun invoke(): Flow<Async<List<Episode>>> = flow {
        emit(Loading<List<Episode>>())
        try {
            emit(Success(repo.getEpisodes()))
        } catch (throwable: Throwable) {
            emit(Failure<List<Episode>>(throwable))
        }
    }
}
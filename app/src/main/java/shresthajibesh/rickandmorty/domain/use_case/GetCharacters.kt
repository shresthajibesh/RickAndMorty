package shresthajibesh.rickandmorty.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import shresthajibesh.rickandmorty.common.Async
import shresthajibesh.rickandmorty.common.Failure
import shresthajibesh.rickandmorty.common.Loading
import shresthajibesh.rickandmorty.common.Success
import shresthajibesh.rickandmorty.domain.model.Character
import shresthajibesh.rickandmorty.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class GetCharacters @Inject constructor(private val repo: RickAndMortyRepository) {
    suspend operator fun invoke(): Flow<Async<List<Character>>> = flow {
        emit(Loading<List<Character>>())
        try {
            emit(Success(repo.getCharacters()))
        } catch (throwable: Throwable) {
            emit(Failure<List<Character>>(throwable))
        }
    }
}
package shresthajibesh.rickandmorty.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import shresthajibesh.rickandmorty.common.Failure
import shresthajibesh.rickandmorty.common.Loading
import shresthajibesh.rickandmorty.common.Success
import shresthajibesh.rickandmorty.common.Uninitialised
import shresthajibesh.rickandmorty.domain.use_case.GetCharacterDetails
import shresthajibesh.rickandmorty.domain.use_case.GetCharacters
import shresthajibesh.rickandmorty.domain.use_case.GetEpisodeDetails
import shresthajibesh.rickandmorty.domain.use_case.GetEpisodes
import shresthajibesh.rickandmorty.domain.use_case.GetLocationDetails
import shresthajibesh.rickandmorty.domain.use_case.GetLocations
import javax.inject.Inject

@HiltViewModel
class DummyViewModel
@Inject constructor(
    val getCharacters: GetCharacters,
    val getCharacterDetails: GetCharacterDetails,
    val getEpisodes: GetEpisodes,
    val getEpisodeDetails: GetEpisodeDetails,
    val getLocations: GetLocations,
    val getLocationDetails: GetLocationDetails
) : ViewModel() {


    private var job: Job? = null
    private var TAG  = "OH_MY_GUTT"
    init {
        job?.cancel()
        job = loadCharacters()
    }

    fun loadCharacters() = viewModelScope.launch {
        Log.i(TAG,"START")

        getCharacters.invoke().onEach { result ->
            when (result) {
                is Failure -> {
                    Log.i(TAG,"Error ${result.error.localizedMessage}")
                    result.error.printStackTrace()
                }
                is Loading -> Log.i(TAG,"Loading")
                is Success -> {
                    Log.i(TAG,"Success")
                    result.data.forEach {
                        Log.i(TAG,"${it.name}")
                    }
                }

                Uninitialised -> Log.i(TAG,"Uninitalised")
            }
        }.launchIn(viewModelScope)
    }


}
package shresthajibesh.rickandmorty.data.remote.models


import com.google.gson.annotations.SerializedName

data class LocationsDTO(
    @SerializedName("info")
    val info: PagingInfo,
    @SerializedName("results")
    val results: List<LocationDTO>
)
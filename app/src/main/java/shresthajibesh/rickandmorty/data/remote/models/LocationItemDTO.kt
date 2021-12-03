package shresthajibesh.rickandmorty.data.remote.models


import com.google.gson.annotations.SerializedName
import shresthajibesh.rickandmorty.common.URLUtils
import shresthajibesh.rickandmorty.domain.model.Location

data class LocationItemDTO(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
) {
    fun toDomain() = Location(
        id = URLUtils.getId(url),
        name = name
    )
}
package shresthajibesh.rickandmorty.data.remote.models


import com.google.gson.annotations.SerializedName
import shresthajibesh.rickandmorty.common.URLUtils
import shresthajibesh.rickandmorty.domain.model.Location
import shresthajibesh.rickandmorty.domain.model.LocationDetails

data class LocationDTO(
    @SerializedName("created")
    val created: String,
    @SerializedName("dimension")
    val dimension: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("residents")
    val residents: List<String>,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
) {
    fun toLocation() = Location(
        id = URLUtils.getId(url),
        name = name
    )

    fun toLocationDetails() = LocationDetails(
        created = created,
        dimension = dimension,
        id = id,
        name = name,
        residents = residents,
        type = type
    )
}
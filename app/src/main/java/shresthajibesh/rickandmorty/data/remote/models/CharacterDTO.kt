package shresthajibesh.rickandmorty.data.remote.models


import com.google.gson.annotations.SerializedName
import shresthajibesh.rickandmorty.domain.model.Character
import shresthajibesh.rickandmorty.domain.model.CharacterDetails

data class CharacterDTO(
    @SerializedName("created")
    val created: String,
    @SerializedName("episode")
    val episode: List<String>,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("location")
    val location: LocationItemDTO,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin")
    val origin: LocationItemDTO,
    @SerializedName("species")
    val species: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("type")
    val type: String,
) {
    fun toCharacter() = Character(
        id = id,
        gender = gender,
        image = image,
        name = name,
        species = species,
        status = status
    )

    fun toCharacterDetails() = CharacterDetails(
        id = id,
        name = name,
        created = created,
        episode = episode,
        gender = gender,
        image = image,
        location = location.toDomain(),
        origin = origin.toDomain(),
        species = species,
        status = status,
        type = type,
    )
}
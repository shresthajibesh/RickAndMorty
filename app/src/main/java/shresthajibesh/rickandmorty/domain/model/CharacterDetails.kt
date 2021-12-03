package shresthajibesh.rickandmorty.domain.model

data class CharacterDetails(
    val id: Int,
    val name: String,
    val created: String,
    val episode: List<String>,
    val gender: String,
    val image: String,
    val location: Location,
    val origin: Location,
    val species: String,
    val status: String,
    val type: String
)

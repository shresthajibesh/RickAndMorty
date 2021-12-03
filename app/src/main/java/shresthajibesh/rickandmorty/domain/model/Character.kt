package shresthajibesh.rickandmorty.domain.model

data class Character(
    val id: Int,
    val gender: String,
    val image: String,
    val name: String,
    val species: String,
    val status: String
)

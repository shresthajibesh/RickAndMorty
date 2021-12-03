package shresthajibesh.rickandmorty.domain.model

data class LocationDetails(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String
)

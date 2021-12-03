package shresthajibesh.rickandmorty.data.remote.models


import com.google.gson.annotations.SerializedName
import shresthajibesh.rickandmorty.domain.model.Episode
import shresthajibesh.rickandmorty.domain.model.EpisodeDetails

data class EpisodeDTO(
    @SerializedName("air_date")
    val airDate: String,
    @SerializedName("characters")
    val characters: List<String>,
    @SerializedName("created")
    val created: String,
    @SerializedName("episode")
    val episode: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
) {
    fun toEpisode() = Episode(
        id = id,
        name = name,
        airDate = airDate
    )

    fun toEpisodeDetails() = EpisodeDetails(
        id = id,
        name = name,
        airDate = airDate,
        characters = characters,
        created = created,
        episodeCode = episode
    )
}
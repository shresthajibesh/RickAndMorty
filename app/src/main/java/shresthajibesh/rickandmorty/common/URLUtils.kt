package shresthajibesh.rickandmorty.common

object URLUtils {

    fun getId(url: String): Int? {
        return try {
            url.split("/").last().toInt()
        } catch (e: Exception) {
            null
        }
    }
}
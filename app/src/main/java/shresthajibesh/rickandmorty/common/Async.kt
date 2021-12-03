package shresthajibesh.rickandmorty.common

sealed class Async<out T>(private val data: T? = null, private val error: Throwable? = null)
object Uninitialised : Async<Nothing>()
data class Loading<out T>(val data: T? = null) : Async<T>(data = data)
data class Success<out T>(val data: T) : Async<T>(data = data)
data class Failure<out T>(val error: Throwable, val data: T? = null) :
    Async<T>(error = error, data = data)

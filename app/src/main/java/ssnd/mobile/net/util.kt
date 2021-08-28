package ssnd.mobile.net

import kotlinx.coroutines.flow.flow
import java.lang.Exception

sealed class NetworkData<out T> {
    object Loading : NetworkData<Nothing>()
    data class Error(val error: Throwable) : NetworkData<Nothing>()
    data class Success<T>(val data: T) : NetworkData<T>()
}

fun <T> request(request: suspend () -> T) = flow {
    emit(NetworkData.Loading)
    try {
        emit(NetworkData.Success(request()))
    } catch (ex: Exception) {
        emit(NetworkData.Error(ex))
    }
}
package andrey.murzin.com.personcapital.domain.model

sealed class ResultWrapper<out T> {
    class Success<out T>(val value: T) : ResultWrapper<T>()
    class Error(val throwable: Throwable) : ResultWrapper<Nothing>()
}
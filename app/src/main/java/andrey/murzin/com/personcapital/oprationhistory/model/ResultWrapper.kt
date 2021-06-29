package andrey.murzin.com.personcapital.oprationhistory.model

sealed class ResultWrapper<out T> {
    class Success<out T>(val value: T) : ResultWrapper<T>()
    class Error(val throwable: Throwable) : ResultWrapper<Nothing>()
}
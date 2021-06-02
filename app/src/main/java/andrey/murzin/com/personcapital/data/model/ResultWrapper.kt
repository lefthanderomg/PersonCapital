package andrey.murzin.com.personcapital.data.model

sealed class ResultWrapper<out T> {
    class Success<out T>(val value: T) : ResultWrapper<T>()
    object Error : ResultWrapper<Nothing>()
}
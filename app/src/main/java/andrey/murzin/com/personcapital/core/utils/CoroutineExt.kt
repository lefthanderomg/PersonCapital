package andrey.murzin.com.personcapital.core.utils

import andrey.murzin.com.personcapital.oprationhistory.model.ResultWrapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

suspend fun <T> safeCall(dispatcher: CoroutineDispatcher, call: suspend () -> T): ResultWrapper<T> {
    return withContext(dispatcher) {
        try {
            val result = call.invoke()
            ResultWrapper.Success(result)
        } catch (throwable: Throwable) {
            ResultWrapper.Error(throwable)
        }
    }
}
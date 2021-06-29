package andrey.murzin.com.personcapital.core.utils

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicReference

fun <A, B, R> Flow<A>.withLatestFrom(other: Flow<B>, transform: suspend (A, B) -> R): Flow<R> =
    flow {
        coroutineScope {
            val latestB = AtomicReference<B?>()
            val outerScope = this

            launch {
                try {
                    other.collect(latestB::set)
                } catch (e: CancellationException) {
                    outerScope.cancel(e)
                }
            }

            collect { a: A ->
                latestB.get()?.let { b: B -> emit(transform.invoke(a, b)) }
            }
        }
    }

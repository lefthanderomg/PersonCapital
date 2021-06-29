package andrey.murzin.com.personcapital.core.base

import kotlinx.coroutines.flow.Flow

interface MviView<A, S> {
    val action: Flow<A>
    fun render(state: S)
}
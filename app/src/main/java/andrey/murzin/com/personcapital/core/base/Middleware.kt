package andrey.murzin.com.personcapital.core.base

import kotlinx.coroutines.flow.Flow

interface Middleware<A, S> {
    fun bind(actions: Flow<A>, state: Flow<S>) : Flow<A>
}
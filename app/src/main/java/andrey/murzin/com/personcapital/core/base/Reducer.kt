package andrey.murzin.com.personcapital.core.base

interface Reducer<S, A> {
    fun reduce(state: S, action: A): S
}
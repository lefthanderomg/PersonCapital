package andrey.murzin.com.personcapital.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi

abstract class BaseViewModel<A, S>(private val store: Store<A, S>) : ViewModel() {
    @ExperimentalCoroutinesApi
    private val wiring = store.wire(viewModelScope)

    val state = store.state

    fun action(action: A) = store.doAction(action, viewModelScope)
}
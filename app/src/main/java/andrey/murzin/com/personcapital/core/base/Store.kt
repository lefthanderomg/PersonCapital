package andrey.murzin.com.personcapital.core.base

import andrey.murzin.com.personcapital.core.utils.withLatestFrom
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class Store<A, S>(
    private val reducer: Reducer<S, A>,
    private val middlewares: List<Middleware<A, S>>,
    initialState: S,
) {
    private val action: MutableStateFlow<A?> = MutableStateFlow(null)

    private val _state: MutableStateFlow<S> = MutableStateFlow(initialState)
    val state: StateFlow<S> = _state

    @ExperimentalCoroutinesApi
    fun wire(scope: CoroutineScope) {
        scope.launch {
            action.mapNotNull { it }
                .withLatestFrom(_state) { action, state ->
                    reducer.reduce(state, action)
                }.distinctUntilChanged()
                .collect(_state::emit)
        }
        scope.launch {
            middlewares.map { middleware ->
                middleware.bind(
                    actions = action.mapNotNull { it },
                    state = _state
                )
            }.merge().collect(action::emit)
        }
    }

    fun doAction(currentAction: A?, scope: CoroutineScope) {
        scope.launch {
            action.emit(currentAction)
        }
    }
}
package andrey.murzin.com.personcapital.oprationhistory.di

import andrey.murzin.com.personcapital.core.base.Store
import andrey.murzin.com.personcapital.oprationhistory.OperationHistoryReducer
import andrey.murzin.com.personcapital.oprationhistory.OperationHistoryState
import andrey.murzin.com.personcapital.oprationhistory.domain.IReportRepository
import andrey.murzin.com.personcapital.oprationhistory.domain.OperationHistoryMiddleware
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
object OperationHistoryModule {

    @ViewModelScoped
    @Provides
    fun provideOperationHistoryStore(
        repository: IReportRepository
    ) =
        Store(
            reducer = OperationHistoryReducer(),
            middlewares = listOf(OperationHistoryMiddleware(repository)),
            initialState = OperationHistoryState.EMPTY
        )
}
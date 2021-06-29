package andrey.murzin.com.personcapital.oprationhistory.di

import andrey.murzin.com.personcapital.oprationhistory.domain.IReportRepository
import andrey.murzin.com.personcapital.core.base.Store
import andrey.murzin.com.personcapital.oprationhistory.domain.OperationHistoryMiddleware
import andrey.murzin.com.personcapital.oprationhistory.OperationHistoryReducer
import andrey.murzin.com.personcapital.oprationhistory.OperationHistoryState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object OperationHistoryModule {

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
package andrey.murzin.com.personcapital.core.di

import andrey.murzin.com.personcapital.oprationhistory.data.ReportRepository
import andrey.murzin.com.personcapital.oprationhistory.domain.IReportRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @Binds
    fun bindReportRepository(repository: ReportRepository) : IReportRepository
}
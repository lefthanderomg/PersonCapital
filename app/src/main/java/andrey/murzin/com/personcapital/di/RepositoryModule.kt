package andrey.murzin.com.personcapital.di

import andrey.murzin.com.personcapital.data.repository.ReportRepository
import andrey.murzin.com.personcapital.domain.repository.IReportRepository
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
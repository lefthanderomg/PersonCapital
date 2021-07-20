package andrey.murzin.com.personcapital.core.di

import andrey.murzin.com.personcapital.core.data.db.PersonCapitalDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DaoModule {

    @Provides
    fun provideReportDao(personCapitalDb: PersonCapitalDb) = personCapitalDb.reportDao()
}
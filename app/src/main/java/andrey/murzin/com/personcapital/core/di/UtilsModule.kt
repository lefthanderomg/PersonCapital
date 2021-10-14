package andrey.murzin.com.personcapital.core.di

import andrey.murzin.com.personcapital.core_data.parser.TinkoffBrokerReportXLSXParser
import andrey.murzin.com.personcapital.core_data.parser.XLSXParser
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface UtilsModule {

    @Binds
    fun bindAnalyticsService(tinkoffBrokerReportXLSXParser: TinkoffBrokerReportXLSXParser): XLSXParser
}
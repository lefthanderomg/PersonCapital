package andrey.murzin.com.personcapital.feature.settings.domain

import andrey.murzin.com.personcapital.feature.oprationhistory.model.ResultWrapper

interface ISettingsRepository {
    suspend fun initMockData(): ResultWrapper<Unit>
}
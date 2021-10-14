package andrey.murzin.com.personcapital.feature.oprationhistory.data.entity

import kotlinx.serialization.Serializable

@Serializable
class MoneyEntity(
    val value: String,
    val currency: String,
)
package andrey.murzin.com.personcapital.core.data.db.converter

import andrey.murzin.com.personcapital.oprationhistory.data.entity.MoneyEntity
import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class MoneyConverter : BaseConverter<MoneyEntity, String> {

    @TypeConverter
    override fun from(from: MoneyEntity): String = Json.encodeToString(from)

    @TypeConverter
    override fun to(to: String): MoneyEntity = Json.decodeFromString(to)
}
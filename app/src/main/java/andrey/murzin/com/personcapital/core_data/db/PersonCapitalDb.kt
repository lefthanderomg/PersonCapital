package andrey.murzin.com.personcapital.core_data.db

import andrey.murzin.com.personcapital.core_data.db.converter.MoneyConverter
import andrey.murzin.com.personcapital.feature.oprationhistory.data.ReportDao
import andrey.murzin.com.personcapital.feature.oprationhistory.data.entity.BrokerReportEntity
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [BrokerReportEntity::class], version = 1)
@TypeConverters(MoneyConverter::class)
abstract class PersonCapitalDb : RoomDatabase() {
    abstract fun reportDao(): ReportDao

    companion object {
        const val DB_NAME = "PERSON_CAPITAL"
    }
}
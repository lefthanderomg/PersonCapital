package andrey.murzin.com.personcapital.oprationhistory.data

import andrey.murzin.com.personcapital.core.data.db.dao.BaseDao
import andrey.murzin.com.personcapital.oprationhistory.data.entity.BrokerReportEntity
import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ReportDao : BaseDao<BrokerReportEntity> {

    @Query("SELECT * FROM BrokerReportEntity")
    fun getAll(): Flow<List<BrokerReportEntity>>
}
package andrey.murzin.com.personcapital.core_data.db.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy

interface BaseDao<T> {
    @Insert
    suspend fun insert(value: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(value: List<T>)
}
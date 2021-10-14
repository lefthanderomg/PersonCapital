package andrey.murzin.com.personcapital.core_data.db.dao

import androidx.room.Insert

interface BaseDao<T> {
    @Insert
    suspend fun insert(value: T)

    @Insert
    suspend fun insertAll(value: List<T>)
}
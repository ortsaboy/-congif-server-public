package com.eventersapp.marketplace.data.local.dao

import androidx.room.*
import com.eventersapp.marketplace.data.model.Account

@Dao
interface AccountsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAccount(account: Account)

    @Query("DELETE FROM ${Account.TABLE_NAME}")
    suspend fun deleteAllTableRecords()

    @Query("SELECT 
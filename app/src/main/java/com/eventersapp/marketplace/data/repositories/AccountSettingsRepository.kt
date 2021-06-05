package com.eventersapp.marketplace.data.repositories

import com.eventersapp.marketplace.data.local.AppDatabase
import com.eventersapp.marketplace.data.model.Account
import com.eventersapp.marketplace.data.network.SafeApiRequest

class AccountSettingsRepository(
    private val db: AppDatabase
) : SafeApiRequest() {

    suspend fun fetchAccounts(): List<Account> {
        return db.getAccountsDao().fetchAllAccount()
    }

    suspend fun updateAc
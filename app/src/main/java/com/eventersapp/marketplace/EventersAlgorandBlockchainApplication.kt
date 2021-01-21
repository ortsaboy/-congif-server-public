package com.eventersapp.marketplace

import android.app.Application
import com.eventersapp.marketplace.data.local.AppDatabase
import com.eventersapp.marketplace.data.network.ApiInterface
import com.eventersapp.marketplace.data.network.BlogApiInterface
import com.eventersapp.marketplace.data.network.NetworkConnectionInterceptor
import com.eventersapp.marketplace.data.repositories.*
import com.eventersapp.marketplace.ui.viewmodelfactory.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.g
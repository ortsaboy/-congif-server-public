package com.eventersapp.marketplace.util

import android.content.Context
import com.google.gson.Gson

object SharedPref {

    private const val EVENTERS_PREFERENCE = "EventersAlgorandBlockchainPreference"
    //<editor-fold desc="Preference Keys">

    const val KEY_USER_DATA = "user_data"
    const val KEY_USER_ID = "user_id"
    const val KEY_PROVIDER = "provider"

    //</editor-fold>

    //<editor-fold desc="Default Values">
    private const val NO_VALUE_PREF = ""
    private const val NO_VALUE = 0
    private const val NO_VALUE_LONG = 0L
    //</editor-fold>

    //<editor-fold desc="Get/Set/Clear Pr
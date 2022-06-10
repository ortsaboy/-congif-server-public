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

    //<editor-fold desc="Get/Set/Clear Pref">

    fun setStringPref(context: Context, key: String, value: String) {
        context.getSharedPreferences(EVENTERS_PREFERENCE, Context.MODE_PRIVATE).edit()
            .putString(key, value)
            .apply()
    }

    fun getStringPref(context: Context, key: String): String {
        return context.getSharedPreferences(
            EVENTERS_PREFERENCE,
            Context.MODE_PRIVATE
        ).getString(key, NO_VALUE_PREF).toString()

    }

    fun setIntegerPref(context: Context, key: String, value: Int) {
        context.getSharedPreferences(EVENTERS_PREFERENCE, Context.MODE_PRIVATE).edit()
            .putInt(key, value)
            .apply()
    }

    fun getIntegerPref(context: Context, key: String): Int {
        return context.getSharedPreferences(EVENTERS_PREFERENCE, Context.MODE_PRIVATE)
            .getInt(key, NO_VALUE)
    }

    fun setLongPref(context: Context, key: String, value: Long) {
        context.getSharedPreferences(EVENTERS_PREFERENCE, Context.MODE_PRIVATE).edit()
            .putLong(key, value)
            .apply()
    }

    fun getLongPref(context: Context, key: String): Long {
        return context.getSharedPreferences(EVENTERS_PREFERENCE, Context.MODE_PRIVATE)
      
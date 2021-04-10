package com.eventersapp.marketplace.data.model

import com.google.gson.annotations.SerializedName

class ConnectPostBody {
    @SerializedName("data")
    var data: Data? = null

    inner class Data {
        @SerializedName("auth")
        var auth: Auth? = null

        @SerializedName("user")
        var user: User? = null
    }

    inner class Auth {
        @SerializedName("device_provider")
        var deviceProvider: String? = null

        @SerializedName("device_id")
        var deviceId: String? = null

        @SerializedName("token_id")
        var tokenId: String? = null

        @SerializedName("fcm_token")
        var fcmToken: String? = null
    }

    inner class User {
        @SerializedName("phone_country_code")
        var phoneCountryCode: String? = null

        @SerializedName("provider")
        var provider: String? = null

        @SerializedName("phone_number")
        var phoneNumber: String? = null

        @SerializedName("phone_firebase_id")
        var phoneFirebaseId: String? = null

        @SerializedName("g_firebase_id")
        var gFirebaseId: String? = null

        @SerializedName("g_email")
        var gEmail: String? = null

        @SerializedName("g_name")
       
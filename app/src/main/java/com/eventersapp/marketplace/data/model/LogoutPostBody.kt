package com.eventersapp.marketplace.data.model

import com.google.gson.annotations.SerializedName

class LogoutPostBody {
    @SerializedName("data")
    var data: Data? = null

    inner class Data {
        @SerializedName("auth")
        var auth: Auth? = null

        @SerializedName("user_device")
        var userDevice: UserDevice? = null
    }

    inner class Auth {
        @SerializedName("auth_type")
        var authType: String? = null

        @SerializedName("device_id")
        var deviceId: String? = null

        @SerializedName("token_id")
        var tokenId: String? = null

        @SerializedName("user_id")
        var userId: Int? =
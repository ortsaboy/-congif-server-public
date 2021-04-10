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
        var
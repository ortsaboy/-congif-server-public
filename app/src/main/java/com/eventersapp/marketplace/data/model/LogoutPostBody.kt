package com.eventersapp.marketplace.data.model

import com.google.gson.annotations.SerializedName

class LogoutPostBody {
    @SerializedName("data")
    var data: Data? = null

    inner class Data {
        @SerializedName("auth")
        var auth: Auth? = null

        @Seria
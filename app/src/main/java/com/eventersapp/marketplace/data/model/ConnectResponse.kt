package com.eventersapp.marketplace.data.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ConnectResponse(
    @SerializedName("data")
    val `data`: Data
) {
    @Keep
    data class Data(
        @SerializedName("user")
        val user: User,
        @SerializedName("auth")
        
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
        val auth: Auth
    ) {
        @Keep
        data class User(
            @SerializedName("address")
            val address: String,
            @SerializedName("city")
            val city: String,
            @SerializedName("country")
            val country: String,
            @SerializedName("display_name")
            val displayName: String,
            @SerializedName("email_
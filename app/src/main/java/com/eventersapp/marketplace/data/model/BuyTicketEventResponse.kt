package com.eventersapp.marketplace.data.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class BuyTicketEventResponse(
    @SerializedName("data")
    val `data`: Data
) {
    @Keep
    data class Data(
        @SerializedName("auth")
        val auth: Auth,
        @SerializedName("public_event")
        val publicEvent: PublicEvent
    ) {
        @Keep
        data class Auth(
            @SerializedName("push_key")
            val pushKey: String
        )

        @Keep
        data class PublicEvent(
            @SerializedName("date_time")
            val dateTime: String,
            @Serializ
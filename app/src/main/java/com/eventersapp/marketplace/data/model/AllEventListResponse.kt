package com.eventersapp.marketplace.data.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Keep
data class AllEventListResponse(
    @SerializedName("data")
    val `data`: List<Data>
) : Serializable {

    @Keep
    data class Data(
        @SerializedName("event_ticket")
        val eventTicket: ArrayList<EventTicket>,
        @SerializedName("public_event")
        val publicEvent: PublicEvent
    ) : Serializable {

        @Keep
        data class EventTicket(
            @SerializedNam
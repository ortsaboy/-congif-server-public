package com.eventersapp.marketplace.data.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Keep
data class MyEventListResponse(
    @SerializedName("data")
    val `data`: ArrayList<Data>
) : Serializable {
    @Keep
    data class Data(
        @SerializedName("event_ticket")
        val eventTicket: EventTicket,
        @SerializedName("public_event")
        val publicEvent: PublicEvent
    ) : Serializable {
        @Keep
        data class EventTicket(
            @SerializedName("event_ticket_id")
            val eventTicketI
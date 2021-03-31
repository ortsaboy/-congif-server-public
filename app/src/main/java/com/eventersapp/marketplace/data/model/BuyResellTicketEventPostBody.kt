package com.eventersapp.marketplace.data.model

import com.google.gson.annotations.SerializedName

class BuyResellTicketEventPostBody {
    @SerializedName("data")
    var data: Data? = null

    inner class Data {
        @SerializedName("ticket")
        var ticket: Ticket? = null

        @SerializedName("auth")
        var auth: Auth? = null

    }

    inner class Auth {
        @SerializedName("auth_type")
        var authType: String? = null

        @SerializedName("device_id")
        var deviceId: String
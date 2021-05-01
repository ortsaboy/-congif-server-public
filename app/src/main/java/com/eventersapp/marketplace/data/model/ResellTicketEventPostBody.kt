package com.eventersapp.marketplace.data.model

import com.google.gson.annotations.SerializedName

class ResellTicketEventPostBody {
    @SerializedName("data")
    var data: Data? = null

    inner class Data {
        @SerializedName("ticket")
        var ti
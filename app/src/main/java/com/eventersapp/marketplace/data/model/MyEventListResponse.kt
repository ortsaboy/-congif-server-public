package com.eventersapp.marketplace.data.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Keep
data class MyEventListResponse(
    @SerializedName("data")
    val `data`: 
package com.eventersapp.marketplace.data.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ProfileResponse(
    @SerializedName("data")
    val `data`: Data
) {
    @Keep
    data class Data(
        @SerializedName("user")
        val user: User
    ) {
        @Keep
        data class User(
            @SerializedName("account_address")
            val accountAddress: String,
            @SerializedName("fb_firebase_id")
            val fbFirebaseId: String,
            @SerializedName("fb_image_url")
            val fbImageUrl: String,
            @SerializedName("fb_name")
            val fbName: String,
            @SerializedName("fb_email")
            val fbEmail: String,
            @SerializedName("g_email")
            val gEmail: String,
            
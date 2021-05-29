package com.eventersapp.marketplace.data.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class VerifiedNumberResponse(
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
            @SerializedName("address")
            val address: String,
            @SerializedName("city")
            val city: String,
            @SerializedName("country")
            val country: String,
            @SerializedName("display_name")
            val displayName: String,
            @SerializedName("email_address")
            val emailAddress: String,
            @SerializedName("fb_email")
            val fbEmail: String,
            @SerializedName("fb_firebase_id")
            val fbFirebaseId: String,
            @SerializedName("fb_image_url")
            val fbImageUrl: String,
            @SerializedName("fb_name")
            val fbName: String,
            @SerializedName("first_name")
            val firstName: String,
            @SerializedName("g_email")
            val gEmail: String,
            @SerializedName("g_firebase_id")
            val gFirebaseId: String,
            @SerializedName("g_image_url")
            val gImageUrl: String,
            @SerializedName("g_name")
            val gName: String,
            @SerializedName("last_name")
            val lastName: String,
            @SerializedName("phone_country_code")
            val phoneCountryCode: String,
            @SerializedName("phone_firebase_id")
            val phoneFirebaseId: String,
            @SerializedName("phone_number")
            val phoneNumber: String,
            @SerializedName("pincode")
            val pincode: String,
            @SerializedName("profile_pic")
            val profilePic: String,
            @SerializedName("provider")
            val provider: String,
            @SerializedName("state")
            val state: Strin
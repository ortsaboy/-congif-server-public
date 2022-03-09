package com.eventersapp.marketplace.ui.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eventersapp.marketplace.data.model.ConnectResponse
import com.eventersapp.marketplace.data.model.CreateEventPostBody
import com.eventersapp.marketplace.data.model.CreateEventResponse
import com.eventersapp.marketplace.data.repositories.CreateEventRepository
import com.eventersapp.marketplace.util.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CreateEventViewModel(private val repository: CreateEventRepository) : ViewModel() {

    companion object {
        const val ONLINE = "online"
    }

    var eventTitle: String? = null
    var eventDescription: String? = null
    var totalTickets: String? = null
    var ticketPrice: String? = null
    var ticketImage: String? = null

    private var firebaseUserToken = ""
    private var deviceId = ""
    private var filePath = ""
    private var mediaName = ""
    private var mediaPath = ""

    private var connectResponse:
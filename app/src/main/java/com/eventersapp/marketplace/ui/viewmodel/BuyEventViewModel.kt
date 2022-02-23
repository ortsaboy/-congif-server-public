package com.eventersapp.marketplace.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eventersapp.marketplace.data.model.*
import com.eventersapp.marketplace.data.repositories.BuyEventRepository
import com.eventersapp.marketplace.util.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class BuyEventViewModel(private val repository: BuyEventRepository) : ViewModel() {


    private var firebaseUserToken = ""
    private var deviceId = ""
    private var toUserId = -1
    private var publicEventId = -1

    private var connectResponse: ConnectResponse? = null
    private var buyNormalTicketEventPostBody: BuyNormalTicketEventPostBody =
        BuyNormalTicketEventPostBody()
    private var buyResellTicketEventPostBody: BuyResellTicketEventPostBody =
        Bu
package com.eventersapp.marketplace.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eventersapp.marketplace.data.model.MyEventListResponse
import com.eventersapp.marketplace.data.repositories.MyEventRepository
import com.eventersapp.marketplace.util.ApiException
import com.eventersapp.marketplace.util.Event
import co
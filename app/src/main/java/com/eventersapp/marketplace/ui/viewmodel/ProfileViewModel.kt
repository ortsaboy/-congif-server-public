package com.eventersapp.marketplace.ui.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eventersapp.marketplace.data.model.LogoutPostBody
import com.eventersapp.marketplace.data.model.LogoutResponse
import com.eventersapp.marketplace.data.model.ProfileResponse
import com.eventersapp.marketplace.data.repositories.ProfileRepository
import com.eventersapp.marketplace.util.*
import com.evente
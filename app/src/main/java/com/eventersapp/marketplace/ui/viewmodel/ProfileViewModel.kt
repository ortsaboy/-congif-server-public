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
import com.eventersapp.marketplace.util.AppConstants.OFFLINE
import com.facebook.login.LoginManager
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileViewModel(private val repository: ProfileRepository) : ViewModel() {

    private var deviceId = ""
    private var userId = -1
    private var firebaseUserToken = ""
    var isProfileApiCalled = false

    private var logoutPostBody: LogoutPostBody = LogoutPostBody()

    private val _logoutLiveData = MutableLiveData<Event<State<LogoutResponse>>>()
    val logoutLiveData: LiveData<Event<State<LogoutResponse>>>
        get() = _logoutLiveData

    private val _profileDetailLiveData = MutableLiveData<State<ProfileResponse>>()
    val profileD
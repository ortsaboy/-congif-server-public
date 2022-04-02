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
    val profileDetailLiveData: LiveData<State<ProfileResponse>>
        get() = _profileDetailLiveData

    private val _accountAddressLiveData = MutableLiveData<String>()
    val accountAddressLiveData: LiveData<String>
        get() = _accountAddressLiveData

    private lateinit var logoutResponse: LogoutResponse
    private lateinit var profileResponse: ProfileResponse

    private fun getProfileDetail() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                profileResponse = repository.getProfile(userId, firebaseUserToken)
                withContext(Dispatchers.Main) {
                    isProfileApiCalled = true
                    fetchSelectedAddressFromDb()
                    _profileDetailLiveData.postValue(
                        State.success(
                            profileResponse

              
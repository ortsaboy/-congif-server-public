package com.eventersapp.marketplace.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eventersapp.marketplace.data.model.ConnectPostBody
import com.eventersapp.marketplace.data.model.ConnectResponse
import com.eventersapp.marketplace.data.network.ApiInterface
import com.eventersapp.marketplace.data.network.SafeApiRequest
import com.eventersapp.marketplace.util.Event
import com.eventersapp.marketplace.util.State
import com.facebook.AccessToken
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class SignupRepository(
    private val api: ApiInterface
) : SafeApiRequest() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _googleUserLiveData =
        MutableLiveData<Event<State<String>>>()
    val googleUserLiveData: LiveData<Event<State<String>>>
        get() = _googleUserLiveData

    private val _facebookUserLiveData =
        MutableLiveData<Event<State<String>>>()
    val facebookUserLiveData: LiveData<Event<State<String>>>
        get() = _facebookUserLiveData

    suspend fun connect(
        connectPostBody: ConnectPostBody
    ): ConnectResponse {

        return apiRequest { api.connectData(connectPostBody) }
    }

    fun firebaseAuthWithGoogle(idToken: String) {
        _googleUserLiveData.postValue(Event(State.loading()))
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.i("Info", "Google sign in success")
                    val user = auth.currentUser
                    _googleUserLiveData.postValue(Event(State.success(user.toString())))
                } else {
                    Log.i("Info", "Google sign in failure", task.exception)
                    _googleUserLiveData.postValue(Event(State.error("Authentication Failed")))
                }
            }
    }

    fun firebaseAuthWithFacebook(token: AccessToken) {
        _facebookUserLiveData.postValue(Event(State.loading()))
        val credential = FacebookAuthProvider.getCredential(token.token)
        auth
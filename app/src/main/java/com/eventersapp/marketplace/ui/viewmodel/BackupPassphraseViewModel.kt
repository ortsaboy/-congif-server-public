package com.eventersapp.marketplace.ui.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.algorand.algosdk.account.Account
import com.eventersapp.marketplace.R
import com.eventersapp.marketplace.util.Event
import org.bouncycastle.jce.provider.BouncyCastleProvider
import java.security.Security

class BackupPassphraseViewModel : ViewModel() {

    var question = MutableLiveData<String>()
    var selectPassPhrase = MutableLiveData<String>()
    private var questionCount = 0
    private var randomNumber = 0
    private var passphraseStr = ""
    private var accountAddress = ""

    private val _messageLiveData = MutableLiveData<Event<String>>()
    val messageLiveData: LiveData<Event<String>>
        get() = _messageLiveData

    private val _questionCountLiveData = MutableLiveData<Event<Int>>()
    val questionCountLiveData: LiveData<Event<Int>>
        get() = _questionCountLiveData

    private val _passphraseListLiveData =
        MutableLiveData<ArrayList<String>>()
    val passphraseListLiveData: LiveData<ArrayList<String>>
        get() = _pas
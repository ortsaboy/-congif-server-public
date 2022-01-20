package com.eventersapp.marketplace.ui.signup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.eventersapp.marketplace.R
import com.eventersapp.marketplace.databinding.SignupScreenFragmentBinding
import com.eventersapp.marketplace.ui.viewmodel.SignupViewModel
import com.eventersapp.marketplace.ui.viewmodelfactory.SignupViewModelFactory
import com.eventersapp.marketplace.util.*
import com.eventersapp.marketplace.util.AppConstants.FACEBOOK
import com.eventersapp.marketplace.util.AppConstants.GOOGLE
import com.eventersapp.marketplace.util.AppConstants.MOBILE_NUMBER_VERIFICATION
import com.eventersapp.marketplace.util.AppUtils.hideProgressBar
import com.eventersapp.marketplace.util.AppUtils.showProgressBar
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance


class SignupScreenFragment : Fragment(), KodeinAware, View.OnClickListener {

    companion object {
        const val GOOGLE_SIGN_IN = 101
    }

    override val kodein by closestKodein()
    private lateinit var dataBind: SignupScreenFragmentBinding
    private val factory: SignupViewModelFactory by instance()
    private val viewModel:
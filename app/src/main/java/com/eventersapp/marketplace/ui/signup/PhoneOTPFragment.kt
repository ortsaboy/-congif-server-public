package com.eventersapp.marketplace.ui.signup

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.eventersapp.marketplace.R
import com.eventersapp.marketplace.databinding.PhoneOtpFragmentBinding
import com.eventersapp.marketplace.ui.viewmodel.PhoneOTPViewModel
import com.eventersapp.marketplace.ui.viewmodelfactory.PhoneOTPViewModelFactory
import com.eventersapp.marketplace.util.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance


class PhoneOTPFragment : Fragment(), KodeinAware {

    override val kodein by closestKodein()
    priv
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
    private lateinit var dataBind: PhoneOtpFragmentBinding
    private val factory: PhoneOTPViewModelFactory by instance()
    private val viewModel: PhoneOTPViewModel by lazy {
        ViewModelProvider(this, factory).get(PhoneOTPViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { arguments ->
            val phoneNumber = arguments.getString("phone_number") ?: ""
            val countryCode = arguments.getString("country_code") ?: ""
            setDeviceInfo()
            sendVerificationCode(Pair(countryCode, phoneNumber))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBind = DataBindingUtil.inflate(
            inflater,
            R.layout.phone_otp_fragment,
            container,
            false
        )
        dataBind.viewmodel = viewModel
        return dataBind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        initializeObserver()
        setupAPICall()
    }

    private fun setupUI() {
        addTextChangedListenerOnEditText()
    }

    private fun initializeObserver() {
        viewModel.messageLiveData.observe(viewLifecycleOwner, EventObserver {
            if (it.isNotBlank()) {
                dataBind.rootLayout.snackbar(it)
            }
        })
    }

    private fun setupAPICall() {
        viewModel.otpStatusLiveData.observe(viewLifecycleOwner, EventObserver { state ->
            when (state) {
                is State.Loading -> {
                    AppUtils.showProgressBar(requireContext())
                }
                is State.Success -> {
                    AppUtils.hideProgressBar()
                    requireActivity().showToast("OTP has been sent to the given phone number")
                }
                is State.Error -> {
                    AppUtils.hideProgressBar()
                    dataBind.rootLayout.snackbar(state.message)
                }
            }
        })

        viewModel.otpVerificationStatusLiveData.observe(viewLifecycleOwner, EventObserver { state ->
            when (state) {
                is State.Loading -> {
  
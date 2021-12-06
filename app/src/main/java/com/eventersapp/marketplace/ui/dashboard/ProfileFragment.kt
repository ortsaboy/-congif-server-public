
package com.eventersapp.marketplace.ui.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.eventersapp.marketplace.R
import com.eventersapp.marketplace.databinding.FragmentProfileBinding
import com.eventersapp.marketplace.ui.viewmodel.ProfileViewModel
import com.eventersapp.marketplace.ui.viewmodelfactory.ProfileViewModelFactory
import com.eventersapp.marketplace.util.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance


class ProfileFragment : Fragment(), KodeinAware, View.OnClickListener {

    companion object {
        private const val ADDRESS = "<Algorand-URL>"//Replace with Algorand address url
    }

    override val kodein by closestKodein()
    private lateinit var dataBind: FragmentProfileBinding
    private val factory: ProfileViewModelFactory by instance()
    private val viewModel: ProfileViewModel by lazy {
        ViewModelProvider(requireActivity(), factory).get(ProfileViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDeviceInfo()
        if (viewModel.isProfileApiCalled) {
            viewModel.getLoadedProfileData()
        } else {
            getJWTToken()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dataBind = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_profile,
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

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.input_profile_address -> {
                requireContext().openInBrowser(ADDRESS + dataBind.inputProfileAddress.text)
            }
            R.id.text_account_settings -> {
                findNavController().navigate(R.id.action_dashboardFragment_to_accountSettingsFragment)
            }
        }
    }

    private fun setupUI() {
        fetchSelectedAddressFromDb()
        dataBind.inputProfileAddress.setOnClickListener(this)
        dataBind.textAccountSettings.setOnClickListener(this)
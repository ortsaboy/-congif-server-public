package com.eventersapp.marketplace.ui.rekeyaccount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.eventersapp.marketplace.R
import com.eventersapp.marketplace.data.model.Account
import com.eventersapp.marketplace.databinding.FragmentRekeyAccountBinding
import com.eventersapp.marketplace.ui.adapter.CustomAdapterRekeyAccount
import com.eventersapp.marketplace.ui.viewmodel.AccountSettingsViewModel
import com.eventersapp.marketplace.ui.viewmodelfactory.AccountSettingsViewModelFactory
import com.eventersapp.marketplace.util.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance


class RekeyAccountFragment : Fragment(), KodeinAware, View.OnClickListener {

    override val kodein by closestKodein()
    private lateinit var dataBind: FragmentRekeyAccountBinding
    private lateinit var customAdapterRekeyAccount: CustomAdapterRekeyAccount
    private val factory: AccountSettingsViewModelFactory by instance()
    private val viewModel: AccountSettingsViewModel by lazy {
        ViewModelProvider(this, factory).get(AccountSettingsViewModel::class.java)
    }
    private latein
package com.eventersapp.marketplace.ui.accountsettings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.eventersapp.marketplace.R
import com.eventersapp.marketplace.databinding.FragmentRecoverPassphraseBinding
import com.eventersapp.marketplace.ui.viewmodel.RecoverPassphraseViewModel
import com.eventersapp.marketplace.ui.viewmodelfactory.RecoverPassphraseViewModelFactory
import com.eventersapp.marketplace.util.EventObserver
import com.eventersapp.marketplace.util.snackbar
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance


class RecoverPassphraseFragment : Fragment(), KodeinAware {


    override val kodein by closestKodein()
    private lateinit var dataBind: FragmentRecoverPassphraseBinding
    private val factory: RecoverPassphraseViewModelFactory by instance()
    private val viewModel: RecoverPassphraseViewModel by lazy {
        ViewModelProvider(this, factory).get(RecoverPassphraseViewModel
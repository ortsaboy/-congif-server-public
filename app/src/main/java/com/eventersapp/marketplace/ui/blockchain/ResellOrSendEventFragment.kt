
package com.eventersapp.marketplace.ui.blockchain

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.eventersapp.marketplace.R
import com.eventersapp.marketplace.data.model.MyEventListResponse
import com.eventersapp.marketplace.databinding.FragmentResellOrSendEventBinding
import com.eventersapp.marketplace.ui.viewmodel.ResellOrSendEventViewModel
import com.eventersapp.marketplace.ui.viewmodelfactory.ResellOrSendEventViewModelFactory
import com.eventersapp.marketplace.util.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance


class ResellOrSendEventFragment : Fragment(), KodeinAware {


    override val kodein by closestKodein()
    private lateinit var dataBind: FragmentResellOrSendEventBinding
    private val factory: ResellOrSendEventViewModelFactory by instance()
    private val viewModel: ResellOrSendEventViewModel by lazy {
        ViewModelProvider(this, factory).get(ResellOrSendEventViewModel::class.java)
    }
    private lateinit var myEvent: MyEventListResponse.Data

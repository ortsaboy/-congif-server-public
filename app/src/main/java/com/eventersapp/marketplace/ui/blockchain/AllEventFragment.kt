package com.eventersapp.marketplace.ui.blockchain

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.eventersapp.marketplace.R
import com.eventersapp.marketplace.databinding.FragmentAllEventBinding
import com.eventersapp.marketplace.ui.adapter.CustomAdapterAllEvent
import com.eventersapp.marketplace.ui.viewmodel.AllEventViewModel
import com.eventersapp.marketplace.ui.viewmodelfactory.AllEventViewModelFactory
import com.eventersapp.marketplace.util.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class AllEventFragment : Fragment(), KodeinAware {


    override val kodein by closestKodein()
    private lateinit var dataBind: FragmentAllEventBinding
    private lateinit var customAdapterAllEvent: CustomAdapterAllEvent
    private val factory: AllEventViewModelFactory by instance()
    private val viewModel: AllEventViewModel by lazy {
        ViewModelProvider(requireActivity(), factory).get(AllEventViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        customAdapterAllEvent = CustomAdapterAllEvent()
        if (viewModel.isAllEventsApiCalled) {
            viewModel.getLoadedAllEventsList()
        } else {
            getAllEvents()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGro
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

class AllEventFragment : Fragment
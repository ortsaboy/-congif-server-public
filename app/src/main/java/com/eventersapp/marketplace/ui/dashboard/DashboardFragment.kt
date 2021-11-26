package com.eventersapp.marketplace.ui.dashboard

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.ImageViewCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.eventersapp.marketplace.R
import com.eventersapp.marketplace.databinding.DashboardFragmentBinding
import com.eventersapp.marketplace.ui.viewmodel.DashboardViewModel
import com.eventersapp.marketplace.util.color


class DashboardFragment : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = DashboardFragment()
    }

    private lateinit var dataBind
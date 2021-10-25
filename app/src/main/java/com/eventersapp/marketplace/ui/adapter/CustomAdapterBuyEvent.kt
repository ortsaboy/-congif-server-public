package com.eventersapp.marketplace.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.eventersapp.marketplace.R
import com.eventersapp.marketplace.data.model.AllEventListResponse
import com.eventersapp.marketplace.databinding.ListItemBuyEventBinding
import com.eventersapp.marketplace.ui.blockchain.BuyEventFragment
import com.eventersapp.marketplace.util.AppConstants
import com.eventersapp.marketplace.util.LoadingViewHolder

class CustomAdapterBuyEvent(private val fragment: BuyEventFragment) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    comp
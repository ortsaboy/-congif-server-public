
package com.eventersapp.marketplace.ui.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.eventersapp.marketplace.R
import com.eventersapp.marketplace.data.model.MyEventListResponse
import com.eventersapp.marketplace.databinding.ListItemMyEventBinding
import com.eventersapp.marketplace.util.AppConstants.API_DATE_FORMAT
import com.eventersapp.marketplace.util.AppConstants.DISPLAY_DATE_FORMAT
import com.eventersapp.marketplace.util.AppUtils
import com.eventersapp.marketplace.util.LoadingViewHolder


class CustomAdapterMyEvent : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_ITEM = 1
        private const val TYPE_LOADING = 2
        private const val ACTIVE = "ACTIVE"
    }

    private var myEventList = ArrayList<MyEventListResponse.Data?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_ITEM -> {
                val binding: ListItemMyEventBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context), R.layout.list_item_my_event, parent,
                    false
                )
                ItemViewHolder(binding)
            }
            else -> {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item_lazy_loading, parent, false)
                LoadingViewHolder(view)
            }
        }
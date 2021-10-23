package com.eventersapp.marketplace.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.eventersapp.marketplace.R
import com.eventersapp.marketplace.data.model.BlogListResponse
import com.eventersapp.marketplace.databinding.ListItemBlogPostsBinding
import com.eventersapp.marketplace.util.AppUtils
import com.eventersapp.marketplace.util.LoadingViewHolder

class CustomAdapterBlog : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_ITEM = 1
        private const val TYPE_LOADING = 2
    }

    private var blogList = ArrayList<BlogListResponse.Post?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_ITEM -> {
                val binding: ListItemBlogPostsBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context), R.layout.list_item_blog_posts, parent,
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
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemViewHolder -> {
                blogList[position]?.let { holder.bindItems(it) }
            }
            is LoadingViewHolder -> {
                holder.showLoadingVi
package com.eventersapp.marketplace.ui.dashboard

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eventersapp.marketplace.R
import com.eventersapp.marketplace.databinding.FragmentBlogBinding
import com.eventersapp.marketplace.ui.adapter.CustomAdapterBlog
import com.eventersapp.marketplace.ui.viewmodel.BlogViewModel
import com.eventersapp.marketplace.ui.viewmodelfactory.BlogViewModelFactory
import com.eventersapp.marketplace.util.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class BlogFragment : Fragment(), KodeinAware {


    override val kodein by closestKodein()
    private lateinit var dataBind: FragmentBlogBinding
    private lateinit var customAdapterBlog: CustomAdapterBlog
    private val factory: BlogViewModelFactory by instance()
    private val viewModel: BlogViewModel by lazy {
        ViewModelProvider(requireActivity(), factory).get(BlogViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        customAdapterBlog = CustomAdapterBlog()
        if (viewModel.isBlogApiCalled) {
            viewModel.getLoadedBlogList()
        } else {
            getBlogList()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBind = DataBindingUtil.inflate(
 
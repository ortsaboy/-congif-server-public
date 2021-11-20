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
            inflater,
            R.layout.fragment_blog,
            container,
            false
        )
        return dataBind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        initializeObserver()
        setupAPICall()
    }

    private fun setupUI() {
        val mLayoutManager = LinearLayoutManager(activity)
        dataBind.recyclerViewBlogPosts.apply {
            isNestedScrollingEnabled = false
            layoutManager = mLayoutManager
            itemAnimator = DefaultItemAnimator()
            adapter = customAdapterBlog
        }
        initScrollListener(dataBind.recyclerViewBlogPosts)
        dataBind.recyclerViewBlogPosts.addOnItemTouchListener(
            RecyclerTouchListener(
                activity,
                dataBind.recyclerViewBlogPosts,
                object : RecyclerTouchListener.ClickListener {

                    override fun onClick(view: View?, position: Int) {
                        AppUtils.openCustomChromeTab(
                            requireContext(),
                            customAdapterBlog.getListData()[position]?.url
                                ?: ""
                        )
                    }

                    override fun onLongClick(view: View?, position: Int) {

                    }
                })
        )
    }

    private fun initializeObserver() {
        viewModel.messageLiveData.observe(viewLifecycleOwner, EventObserver
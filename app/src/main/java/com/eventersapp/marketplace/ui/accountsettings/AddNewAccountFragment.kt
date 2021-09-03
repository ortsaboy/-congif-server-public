package com.eventersapp.marketplace.ui.accountsettings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.eventersapp.marketplace.R
import com.eventersapp.marketplace.databinding.FragmentAddNewAccountBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein


class AddNewAccountFragment : Fragment(), KodeinAware, View.OnClickListener {


    override val kodein by closestKodein()
    private lateinit var dataBind: FragmentAddNewAccountBinding


    over
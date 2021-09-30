package com.eventersapp.marketplace.ui.accountsettings

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.eventersapp.marketplace.R
import com.eventersapp.marketplace.databinding.PassphraseVerifiedBottomSheetBinding
import com.eventersapp.marketplace.ui.viewmodel.BackupPassphraseViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PassphraseVerifiedBottomDialogFragment : BottomSheetDialogFragment() {


    private lateinit var dataBind: PassphraseVerifiedBottomSheetBinding
    private val viewModel: BackupPassphraseViewModel by lazy {
        ViewModelProvider(requireActivity()).get(BackupPassphraseViewModel::class.java)
    }

    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(requireContext(), theme).apply {
            isCancelable = false
         
package com.eventersapp.marketplace.ui.dashboard

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import com.eventersapp.marketplace.R
import com.eventersapp.marketplace.databinding.ShowScanResultOfQrCodeBottomSheetBinding
import com.eventersapp.marketplace.util.copyToClipboard
import com.eventersapp.marketplace.util.showToast
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class ShowScanResultOfQRCodeBottomDialogFragment : BottomSheetDialogFragment(),
    View.OnClickListener {

    companion object {
        fun newInstance(): ShowScanResultOfQRCodeBottomDialogFragment {
            return ShowScanResultOfQRCodeBottomDialogFragment()
        }
    }

    private lateinit var dataBind: Show
package com.eventersapp.marketplace.util

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.view.Window
import android.view.WindowManager
import com.eventersapp.marketplace.R

class ProgressBar {
    private var dialog: Dialog? = null

    companion object {

        @SuppressLint("StaticFieldLeak")
        private var gifProgress: ProgressBar? = null

        fun getInstance(): ProgressBar {
            if (gifProgress == null) {
                gifProgress = ProgressBar()
            }
            return gifProgress as ProgressBar
        }

    }

    fun showProgress(context: Context, cancelable: Boolean) {
        dialog = Dialog(context)

        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setContentView(R.layout.dialog_progress_bar)

        val layoutParams = WindowManager.LayoutParams()
        layoutParams.c
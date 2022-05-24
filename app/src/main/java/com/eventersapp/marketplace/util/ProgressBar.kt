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
          
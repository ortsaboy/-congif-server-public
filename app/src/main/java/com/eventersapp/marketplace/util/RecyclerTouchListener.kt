package com.eventersapp.marketplace.util

import android.content.Context
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class RecyclerTouchListener(
    context: Context?,
    recyclerView: RecyclerView,
    private var cli
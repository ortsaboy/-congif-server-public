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
    private var clickListener: ClickListener?
) : RecyclerView.OnItemTouchListener {

    private var gestureDetector: GestureDetector? = null

    init {
        gestureDetector = GestureDetector(context, object : SimpleOnGestureListener() {
            override fun onSingleTapUp(e: MotionEvent): Boolean {
                return true
            }

            override fun onLongPress(e: MotionEvent) {
 
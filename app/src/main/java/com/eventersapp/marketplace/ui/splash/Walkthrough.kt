package com.eventersapp.marketplace.ui.splash

import android.os.Bundle
import com.chyrta.onboarder.OnboarderActivity
import com.chyrta.onboarder.OnboarderPage
import com.eventersapp.marketplace.HostActivity
import com.eventersapp.marketplace.R
import com.eventersapp.marketplace.util.goToActivity


class Walkthrough : OnboarderActivity() {

    private var onboarderPages: List<OnboarderPage>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onboarderPages = ArrayList()
        val onboarderPage1 =
            OnboarderPage(
                "Event App",
                "All event suites like guest management, invites, website and app in one place. It is part of Organiser toolkit",
                R.drawable.onboard_mobile_img
            )
        val onboarderPage2 =
            OnboarderPage(
                "Personalised Website",
                "Your stories and memories in one place
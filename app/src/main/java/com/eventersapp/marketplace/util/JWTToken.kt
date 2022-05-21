package com.eventersapp.marketplace.util

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

suspend fun getFirebaseUserToken(): String = suspendCancellableCoroutine { co
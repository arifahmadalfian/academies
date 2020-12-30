package com.arifahmadalfian.academies.utils

import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResources {

    private const val RESOURCE = "GLOBAL"
    val espressoTestIdlingResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        espressoTestIdlingResource.increment()
    }

    fun decrement() {
        espressoTestIdlingResource.decrement()
    }
}
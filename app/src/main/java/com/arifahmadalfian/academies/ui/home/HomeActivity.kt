package com.arifahmadalfian.academies.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arifahmadalfian.academies.R
import com.arifahmadalfian.academies.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var homeActivityBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeActivityBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeActivityBinding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        homeActivityBinding.viewPager.adapter = sectionsPagerAdapter
        homeActivityBinding.tabs.setupWithViewPager(homeActivityBinding.viewPager)

        supportActionBar?.elevation = 0f
    }
}
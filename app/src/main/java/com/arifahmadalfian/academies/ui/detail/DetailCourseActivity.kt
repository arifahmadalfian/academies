package com.arifahmadalfian.academies.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arifahmadalfian.academies.databinding.ActivityDetailCourseBinding
import com.arifahmadalfian.academies.databinding.ContentDetailCourseBinding

class DetailCourseActivity : AppCompatActivity() {

    private lateinit var detailContentBinding: ContentDetailCourseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailCourseBinding = ActivityDetailCourseBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailCourseBinding.detailContent

        setContentView(activityDetailCourseBinding.root)

        setSupportActionBar(activityDetailCourseBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
package com.arifahmadalfian.academies.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.arifahmadalfian.academies.data.CourseEntity
import com.arifahmadalfian.academies.data.source.AcademyRepository
import com.arifahmadalfian.academies.utils.DataDummy

class AcademyViewModel(private val academyRepository: AcademyRepository): ViewModel() {

    fun getCourses(): LiveData<List<CourseEntity>> = academyRepository.getAllCourses()
}
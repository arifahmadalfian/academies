package com.arifahmadalfian.academies.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.arifahmadalfian.academies.data.source.local.entity.CourseEntity
import com.arifahmadalfian.academies.data.AcademyRepository
import com.arifahmadalfian.academies.vo.Resource

class AcademyViewModel(private val academyRepository: AcademyRepository): ViewModel() {

    fun getCourses(): LiveData<Resource<List<CourseEntity>>> = academyRepository.getAllCourses()
}
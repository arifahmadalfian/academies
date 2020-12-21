package com.arifahmadalfian.academies.ui.detail

import androidx.lifecycle.ViewModel
import com.arifahmadalfian.academies.data.CourseEntity
import com.arifahmadalfian.academies.data.ModuleEntity
import com.arifahmadalfian.academies.data.source.AcademyRepository
import com.arifahmadalfian.academies.utils.DataDummy

class DetailCourseViewModel(private val academyRepository: AcademyRepository): ViewModel() {
    private lateinit var courseId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun getCourse(): CourseEntity = academyRepository.getCourseWithModules(courseId)

    fun getModules(): List<ModuleEntity> = academyRepository.getAllModulesByCourse(courseId)
}
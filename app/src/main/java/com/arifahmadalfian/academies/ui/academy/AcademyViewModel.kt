package com.arifahmadalfian.academies.ui.academy

import androidx.lifecycle.ViewModel
import com.arifahmadalfian.academies.data.CourseEntity
import com.arifahmadalfian.academies.utils.DataDummy

class AcademyViewModel: ViewModel() {

    fun getCourses(): List<CourseEntity> = DataDummy.generateDummyCourses()
}
package com.arifahmadalfian.academies.ui.bookmark

import androidx.lifecycle.ViewModel
import com.arifahmadalfian.academies.data.CourseEntity
import com.arifahmadalfian.academies.data.source.AcademyRepository
import com.arifahmadalfian.academies.utils.DataDummy

class BookmarkViewModel(private val academyRepository: AcademyRepository): ViewModel() {
    fun getBookmark(): List<CourseEntity> = academyRepository.getBookmarkedCourses()
}
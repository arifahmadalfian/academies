package com.arifahmadalfian.academies.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.arifahmadalfian.academies.data.source.local.entity.CourseEntity
import com.arifahmadalfian.academies.data.AcademyRepository

class BookmarkViewModel(private val academyRepository: AcademyRepository): ViewModel() {
    fun getBookmark(): LiveData<PagedList<CourseEntity>> = academyRepository.getBookmarkedCourses()

    fun setBookmark(courseEntity: CourseEntity) {
        val newState = !courseEntity.bookmarked
        academyRepository.setCourseBookmarked(courseEntity, newState)
    }
}
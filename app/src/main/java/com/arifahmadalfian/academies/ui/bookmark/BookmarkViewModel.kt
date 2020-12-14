package com.arifahmadalfian.academies.ui.bookmark

import androidx.lifecycle.ViewModel
import com.arifahmadalfian.academies.data.CourseEntity
import com.arifahmadalfian.academies.utils.DataDummy

class BookmarkViewModel: ViewModel() {
    fun getBookmark(): List<CourseEntity> = DataDummy.generateDummyCourses()
}
package com.arifahmadalfian.academies.ui.bookmark

import com.arifahmadalfian.academies.data.CourseEntity

interface IBookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}

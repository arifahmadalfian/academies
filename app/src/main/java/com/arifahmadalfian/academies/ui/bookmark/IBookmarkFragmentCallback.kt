package com.arifahmadalfian.academies.ui.bookmark

import com.arifahmadalfian.academies.data.source.local.entity.CourseEntity

interface IBookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}

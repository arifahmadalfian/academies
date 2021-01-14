package com.arifahmadalfian.academies.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.arifahmadalfian.academies.data.source.local.entity.CourseEntity
import com.arifahmadalfian.academies.data.source.local.entity.CourseWithModule
import com.arifahmadalfian.academies.data.source.local.entity.ModuleEntity
import com.arifahmadalfian.academies.vo.Resource

interface AcademyDataSource {

    fun getAllCourses(): LiveData<Resource<PagedList<CourseEntity>>>

    fun getCourseWithModules(courseId: String): LiveData<Resource<CourseWithModule>>

    fun getAllModulesByCourse(courseId: String): LiveData<Resource<List<ModuleEntity>>>

    fun getContent(moduleId: String): LiveData<Resource<ModuleEntity>>

    fun getBookmarkedCourses(): LiveData<PagedList<CourseEntity>>

    fun setCourseBookmarked(course: CourseEntity, state: Boolean)

    fun setReadModule(module: ModuleEntity)

}
package com.arifahmadalfian.academies.ui.reader

import androidx.lifecycle.ViewModel
import com.arifahmadalfian.academies.data.ContentEntity
import com.arifahmadalfian.academies.data.ModuleEntity
import com.arifahmadalfian.academies.utils.DataDummy

class CourseReaderViewModel: ViewModel() {

    private lateinit var courseId: String
    private lateinit var moduleId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun setSelectedModule(moduleId: String) {
        this.moduleId = moduleId
    }

    fun getModules(): ArrayList<ModuleEntity> = DataDummy.generateDummyModules(courseId) as ArrayList<ModuleEntity>

    fun getSelectedModule(): ModuleEntity {
        lateinit var module: ModuleEntity
        val moduleEntities = getModules()
        for (moduleEntity in moduleEntities) {
            if (moduleEntity.moduleId == moduleId) {
                module = moduleEntity
                module.contentEntity = ContentEntity("<h3 class =\\\"fr-text-bordered\\\">" + module.title +"</h3><p>Lorem ipsum dolor sit amet, consecterur adipiscing elit, sed do eiusmod tempor incidudunt ut labore et dolore magna aliqua. Ut enim ad minim vveniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea dommodo consequat. duis aute irure dolor in reprehenderi in voluptate velit esse cillum dolore eu fugiat nulla pariatur . Excepterur sint occaecat cupidatat non proident, sunt in culpa qui officia deseruuunt mollit anikm id est laborum .</p>")
                break
            }
        }
        return module
    }
}
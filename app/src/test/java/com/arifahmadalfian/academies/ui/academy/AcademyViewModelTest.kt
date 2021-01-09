package com.arifahmadalfian.academies.ui.academy

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.arifahmadalfian.academies.data.source.local.entity.CourseEntity
import com.arifahmadalfian.academies.data.AcademyRepository
import com.arifahmadalfian.academies.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AcademyViewModelTest {
    private lateinit var viewModel: AcademyViewModel

    @get:Rule
    var instantTaskExecutor = InstantTaskExecutorRule()

    @Mock
    private lateinit var academyRepository: AcademyRepository
    @Mock
    private lateinit var observer: Observer<List<CourseEntity>>

    @Before
    fun setUp() {
        viewModel = AcademyViewModel(academyRepository)
    }

    @Test
    fun getCourses() {
        val dummyCourses = DataDummy.generateDummyCourses()
        val courses = MutableLiveData<List<CourseEntity>>()
        courses.value = dummyCourses

        Mockito.`when`(academyRepository.getAllCourses()).thenReturn(courses)
        val courseEntities = viewModel.getCourses().value
        Mockito.verify<AcademyRepository>(academyRepository).getAllCourses()
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities?.size)

        viewModel.getCourses().observeForever(observer)
        verify(observer).onChanged(dummyCourses)
    }
}
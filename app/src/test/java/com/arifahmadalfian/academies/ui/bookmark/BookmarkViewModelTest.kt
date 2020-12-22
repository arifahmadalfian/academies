package com.arifahmadalfian.academies.ui.bookmark

import com.arifahmadalfian.academies.data.CourseEntity
import com.arifahmadalfian.academies.data.source.AcademyRepository
import com.arifahmadalfian.academies.utils.DataDummy
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BookmarkViewModelTest {

    private lateinit var viewModel: BookmarkViewModel

    @Mock
    private lateinit var academyRepository: AcademyRepository

    @Before
    fun setUp() {
        viewModel = BookmarkViewModel(academyRepository)
    }

    @Test
    fun getBookmark() {
        `when`<ArrayList<CourseEntity>>(academyRepository.getBookmarkedCourses() as ArrayList<CourseEntity>?).thenReturn(
            DataDummy.generateDummyCourses() as ArrayList<CourseEntity>?
        )
        val coursesEnitites = viewModel.getBookmark()
        verify<AcademyRepository>(academyRepository).getBookmarkedCourses()
        assertNotNull(coursesEnitites)
        assertEquals(5, coursesEnitites.size)
    }
}
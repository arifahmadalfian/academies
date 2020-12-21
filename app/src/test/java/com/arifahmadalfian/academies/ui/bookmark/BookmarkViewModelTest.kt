package com.arifahmadalfian.academies.ui.bookmark

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class BookmarkViewModelTest {

    private lateinit var viewModel: BookmarkViewModel

    @Before
    fun setUp() {
        viewModel = BookmarkViewModel()
    }

    @Test
    fun getBookmark() {
        val coursesEnitites = viewModel.getBookmark()
        assertNotNull(coursesEnitites)
        assertEquals(5, coursesEnitites.size)
    }
}
package com.arifahmadalfian.academies.di

import android.content.Context
import com.arifahmadalfian.academies.data.source.AcademyRepository
import com.arifahmadalfian.academies.data.source.remote.RemoteDataSource
import com.arifahmadalfian.academies.utils.JsonHelper

object Injection {
    fun privideRepository(context: Context): AcademyRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return AcademyRepository.getInstance(remoteDataSource)
    }
}
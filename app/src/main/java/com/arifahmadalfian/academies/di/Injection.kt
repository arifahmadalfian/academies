package com.arifahmadalfian.academies.di

import android.content.Context
import com.arifahmadalfian.academies.data.AcademyRepository
import com.arifahmadalfian.academies.data.source.local.LocalDataSource
import com.arifahmadalfian.academies.data.source.local.room.AcademyDatabase
import com.arifahmadalfian.academies.data.source.remote.RemoteDataSource
import com.arifahmadalfian.academies.utils.AppExecutors
import com.arifahmadalfian.academies.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): AcademyRepository {

        val database = AcademyDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.academyDao())
        val appExecutors = AppExecutors()

        return AcademyRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}
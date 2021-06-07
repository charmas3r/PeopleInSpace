package com.sdss.common.repository

import co.touchlab.kermit.LogcatLogger
import co.touchlab.kermit.Logger
import com.sdss.workout.db.WorkoutDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.sdss.common.di.PeopleInSpaceDatabaseWrapper
import org.koin.dsl.module

actual fun platformModule() = module {
    single {
        val driver =
            AndroidSqliteDriver(WorkoutDatabase.Schema, get(), "workout.db")

        PeopleInSpaceDatabaseWrapper(WorkoutDatabase(driver))
    }
    single<Logger>{ LogcatLogger() }
}


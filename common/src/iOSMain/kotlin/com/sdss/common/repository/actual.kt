package com.sdss.common.repository

import co.touchlab.kermit.Logger
import co.touchlab.kermit.NSLogLogger
import com.sdss.workout.db.WorkoutDatabase
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import com.surrus.common.di.PeopleInSpaceDatabaseWrapper
import org.koin.dsl.module

actual fun platformModule() = module {
    single {
        val driver = NativeSqliteDriver(WorkoutDatabase.Schema, "workout.db")
        PeopleInSpaceDatabaseWrapper(WorkoutDatabase(driver))
    }
    single<Logger>{ NSLogLogger() }
}

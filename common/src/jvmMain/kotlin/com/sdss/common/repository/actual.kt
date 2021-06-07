package com.sdss.common.repository

import co.touchlab.kermit.CommonLogger
import co.touchlab.kermit.Logger
import com.sdss.workout.db.WorkoutDatabase
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import com.surrus.common.di.PeopleInSpaceDatabaseWrapper
import org.koin.dsl.module

actual fun platformModule() = module {
    single {
        val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
            .also { WorkoutDatabase.Schema.create(it) }
        PeopleInSpaceDatabaseWrapper(WorkoutDatabase(driver))
    }

    single<Logger>{ CommonLogger() }
}
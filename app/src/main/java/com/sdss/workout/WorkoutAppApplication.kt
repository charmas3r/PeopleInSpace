package com.sdss.workout

import android.app.Application
import co.touchlab.kermit.Kermit
import com.sdss.common.di.initKoin
import com.sdss.workout.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class WorkoutAppApplication : Application(), KoinComponent {
    private val logger: Kermit by inject()

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger()
            androidContext(this@WorkoutAppApplication)
            modules(appModule)
        }

        logger.d { "WorkoutAppApplication" }
    }
}
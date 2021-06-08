package com.sdss.workout.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.sdss.workout.BuildConfig
import org.osmdroid.config.Configuration

abstract class BaseActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // needed for osmandroid
        Configuration.getInstance().userAgentValue = BuildConfig.APPLICATION_ID
    }
}
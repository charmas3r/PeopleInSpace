package com.sdss.workout.di

import com.sdss.workout.workout.ExampleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ExampleViewModel(get(),get()) }
}

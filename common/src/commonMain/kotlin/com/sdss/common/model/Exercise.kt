package com.sdss.common.model

data class Exercise(
    val name: String = "Test Exercise Name",
    val category: ExerciseCategory = ExerciseCategory.Chest,
    val sets: List<ExerciseSet> = listOf(
        ExerciseSet(
            reps = 5,
            percentageOneRepMax = .75F
        ),
        ExerciseSet(
            reps = 5,
            percentageOneRepMax = .85F
        ),
        ExerciseSet(
            reps = 5,
            percentageOneRepMax = .95F
        )
    )
)

data class ExerciseSet(
    val amrap: Boolean = false,
    val reps: Int = 5,
    val percentageOneRepMax: Float = .75F
)

sealed class ExerciseCategory {
    object Shoulders: ExerciseCategory()
    object Arms: ExerciseCategory()
    object Back: ExerciseCategory()
    object Chest: ExerciseCategory()
    object Legs: ExerciseCategory()
    object Custom: ExerciseCategory()
    object Assistance: ExerciseCategory()
}
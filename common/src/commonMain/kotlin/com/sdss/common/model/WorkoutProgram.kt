package com.sdss.common.model

data class WorkoutProgram(
    val cycles: Int = 12,
    val name: String,
    val description: String,
    val weeks: List<ProgramWeek>,
    val assistanceExercises: List<Exercise>
)

data class ProgramWeek(
    val isDeload: Boolean = false,
    val weekExercises: List<Exercise>
)

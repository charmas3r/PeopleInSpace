package com.sdss.common.model

val testProgram = WorkoutProgram(
    cycles = 12,
    name = "Beginner 5/3/1",
    description = "The core philosophy behind 5/3/1 revolves around the basic tenets of strength training that have stood the test of time.",
    weeks = listOf(
        ProgramWeek(
            weekExercises = listOf(
                Exercise(
                    name = "Overhead Press",
                    category = ExerciseCategory.Shoulders,
                    sets = listOf(
                        ExerciseSet(
                            reps = 5,
                            percentageOneRepMax = .65F
                        ),
                        ExerciseSet(
                            reps = 5,
                            percentageOneRepMax = .75F
                        ),
                        ExerciseSet(
                            amrap = true,
                            reps = 5,
                            percentageOneRepMax = .85F
                        )
                    )
                ),
                Exercise(
                    name = "Bench Press",
                    category = ExerciseCategory.Chest,
                    sets = listOf(
                        ExerciseSet(
                            reps = 5,
                            percentageOneRepMax = .65F
                        ),
                        ExerciseSet(
                            reps = 5,
                            percentageOneRepMax = .75F
                        ),
                        ExerciseSet(
                            amrap = true,
                            reps = 5,
                            percentageOneRepMax = .85F
                        )
                    )
                ),
                Exercise(
                    name = "Squats",
                    category = ExerciseCategory.Legs,
                    sets = listOf(
                        ExerciseSet(
                            reps = 5,
                            percentageOneRepMax = .65F
                        ),
                        ExerciseSet(
                            reps = 5,
                            percentageOneRepMax = .75F
                        ),
                        ExerciseSet(
                            amrap = true,
                            reps = 5,
                            percentageOneRepMax = .85F
                        )
                    )
                ),
                Exercise(
                    name = "Deadlifts",
                    category = ExerciseCategory.Back,
                    sets = listOf(
                        ExerciseSet(
                            reps = 5,
                            percentageOneRepMax = .65F
                        ),
                        ExerciseSet(
                            reps = 5,
                            percentageOneRepMax = .75F
                        ),
                        ExerciseSet(
                            amrap = true,
                            reps = 5,
                            percentageOneRepMax = .85F
                        )
                    )
                )
            )
        )
    ),
    assistanceExercises = listOf(
        Exercise(
            name = "Boring But Big",
            category = ExerciseCategory.Assistance,
            sets = listOf(
                ExerciseSet(
                    reps = 5,
                    percentageOneRepMax = .55F
                ),
                ExerciseSet(
                    reps = 5,
                    percentageOneRepMax = .55F
                ),
                ExerciseSet(
                    reps = 5,
                    percentageOneRepMax = .55F
                ),
                ExerciseSet(
                    reps = 5,
                    percentageOneRepMax = .55F
                ),
                ExerciseSet(
                    reps = 5,
                    percentageOneRepMax = .55F
                )
            )
        ),
        Exercise(
            name = "Pyramid",
            category = ExerciseCategory.Assistance
        ),
        Exercise(
            name = "First Set Last",
            category = ExerciseCategory.Assistance
        ),
        Exercise(
            name = "Joker Sets",
            category = ExerciseCategory.Assistance
        )
    )
)
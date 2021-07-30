package com.sdss.common.model

data class User(
    val weight: Int = 0,
    val oneRepMax: OneRepMax = OneRepMax(),
    val weightPreference: WeightUnits = WeightUnits.LB,
    val isSubscribed: Boolean = true,
)

data class OneRepMax(
    val benchMax: Int = 0,
    val benchUnits: WeightUnits = WeightUnits.LB,
    val squatMax: Int = 0,
    val squatUnits: WeightUnits = WeightUnits.LB,
    val deadMax: Int = 0,
    val deadUnits: WeightUnits = WeightUnits.LB,
    val shoulderMax: Int = 0,
    val shoulderUnits: WeightUnits = WeightUnits.LB
)
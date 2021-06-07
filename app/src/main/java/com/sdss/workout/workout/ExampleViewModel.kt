package com.sdss.workout.workout

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Kermit
import com.sdss.common.remote.Assignment
import com.sdss.common.repository.PeopleInSpaceRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class ExampleViewModel(
    private val peopleInSpaceRepository: PeopleInSpaceRepository,
    private val logger: Kermit
) : ViewModel() {

    val peopleInSpace = peopleInSpaceRepository.fetchPeopleAsFlow()
            .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    val issPosition = peopleInSpaceRepository.pollISSPosition()

    fun getPersonBio(personName: String): String {
        return peopleInSpaceRepository.getPersonBio(personName)
    }

    fun getPersonImage(personName: String): String {
        return peopleInSpaceRepository.getPersonImage(personName)
    }

    fun getPerson(personName: String): Assignment? {
        return peopleInSpace.value.find { it.name == personName}
    }
}
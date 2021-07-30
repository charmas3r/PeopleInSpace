package com.sdss

import com.sdss.common.di.initKoin
import com.sdss.common.remote.PeopleInSpaceApi
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val koin = initKoin(enableNetworkLogs = true).koin
        val api = koin.get<PeopleInSpaceApi>()
        println(api.fetchPeople())
    }
}

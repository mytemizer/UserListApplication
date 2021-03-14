package com.global.userlistapplication.ui

import com.global.userlistapplication.data.PersonRepository
import com.global.userlistapplication.data.ResourceHandler
import javax.inject.Inject

class FetchPersonListUseCase @Inject constructor(private val repository: PersonRepository) {

    fun fetchPersonList(next: String?, resourceHandler: ResourceHandler) {
        repository.fetchPersonList(next, resourceHandler)
    }
}
package com.global.userlistapplication.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.global.userlistapplication.common.Resource
import com.global.userlistapplication.common.Status
import com.global.userlistapplication.data.FetchResponse
import com.global.userlistapplication.data.Person
import javax.inject.Inject

class PersonListViewModel @Inject constructor(
    private val fetchPersonListUseCase: FetchPersonListUseCase
) : ViewModel() {

    val status = MutableLiveData<PersonListStatusViewState>()

    val personIdSet = HashSet<Int>()

    private val personList = ArrayList<Person>()
    val personListLD = MutableLiveData<List<Person>>()

    var next: String? = null

    fun fetchPersonList() {
        fetchPersonListUseCase.fetchPersonList(
            next,
            resourceHandler = { resource ->
                val viewState = when (resource) {
                    is Resource.Success -> {
                        doSuccessOperation(resource)
                        PersonListStatusViewState(Status.Content)
                    }
                    is Resource.Error -> PersonListStatusViewState(Status.Error(resource.exception))
                    else -> PersonListStatusViewState(Status.Loading)
                }
                status.value = viewState
            })
    }

    private fun doSuccessOperation(resource: Resource.Success<Any>) {
        if (resource.data is FetchResponse) {
            val data = resource.data

            for (person: Person in data.people) {
                if (!personIdSet.contains(person.id)) {
                    personList.add(person)
                    personIdSet.add(person.id)
                }
            }
            personListLD.value = personList
            next = data.next
        }
    }

    fun reset() {
        personListLD.value = ArrayList()
        personList.clear()
        personIdSet.clear()
    }


}
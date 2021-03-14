package com.global.userlistapplication.ui

import com.global.userlistapplication.data.Person

class PersonListItemViewState(private val person: Person) {

    fun getFullName() = person.fullName

    fun getId() = person.id

}
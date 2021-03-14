package com.global.userlistapplication.ui

import com.global.userlistapplication.common.Status

class PersonListStatusViewState(private val status: Status) {

    fun isLoading() = status is Status.Loading

    fun getErrorMessage() =
        if (status is Status.Error) status.exception.message else "Error Occurred!"

    fun shouldShowErrorMessage() = status is Status.Error
}
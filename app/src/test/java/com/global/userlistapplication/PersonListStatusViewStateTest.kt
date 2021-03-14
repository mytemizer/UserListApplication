package com.global.userlistapplication

import com.global.userlistapplication.common.Status
import com.global.userlistapplication.ui.PersonListStatusViewState
import com.google.common.truth.Truth
import org.junit.Test

class PersonListStatusViewStateTest {

    @Test
    fun `should return loading true when status is loading`() {

        // Given
        val givenViewState =
            PersonListStatusViewState(status = Status.Loading)

        // When
        val actualResult = givenViewState.isLoading()

        // Then
        Truth.assertThat(actualResult).isTrue()
    }

    @Test
    fun `should not return loading false when status is error`() {

        // Given
        val givenViewState =
            PersonListStatusViewState(status = Status.Error(Exception()))

        // When
        val actualResult = givenViewState.isLoading()

        // Then
        Truth.assertThat(actualResult).isFalse()
    }

    @Test
    fun `should not return loading false when status is success`() {

        // Given
        val givenViewState = PersonListStatusViewState(status = Status.Content)

        // When
        val actualResult = givenViewState.isLoading()

        // Then
        Truth.assertThat(actualResult).isFalse()
    }

    @Test
    fun `should return correct error message when status is error`() {

        // Given
        val givenViewState =
            PersonListStatusViewState(
                status = Status.Error(Exception("Internal Server Error"))
            )

        // When
        val actualResult = givenViewState.getErrorMessage()

        // Then
        Truth.assertThat(actualResult).isEqualTo("Internal Server Error")
    }

    @Test
    fun `should return true for error placeholder visibility  when status is error`() {

        // Given
        val givenViewState =
            PersonListStatusViewState(
                status = Status.Error(Exception("Internal Server Error"))
            )

        // When
        val actualResult = givenViewState.shouldShowErrorMessage()

        // Then
        Truth.assertThat(actualResult).isTrue()
    }
}
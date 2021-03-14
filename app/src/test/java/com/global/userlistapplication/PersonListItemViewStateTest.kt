package com.global.userlistapplication

import com.global.userlistapplication.data.Person
import com.global.userlistapplication.ui.PersonListItemViewState
import com.google.common.truth.Truth
import org.junit.Test

class PersonListItemViewStateTest {

    @Test
    fun `should match person full name for given person`() {

        // Given
        val person = createDummyPerson()
        val givenViewState = PersonListItemViewState(person)

        // When
        val actualResult = givenViewState.getFullName()

        // Then
        Truth.assertThat(actualResult).isEqualTo("Muhammed Yusuf Temizer")
    }

    @Test
    fun `should match person id for given person`() {

        // Given
        val person = createDummyPerson()
        val givenViewState = PersonListItemViewState(person)

        // When
        val actualResult = givenViewState.getId()

        // Then
        Truth.assertThat(actualResult).isEqualTo(1)
    }

    private fun createDummyPerson(): Person {
        return Person(1, "Muhammed Yusuf Temizer")
    }
}
package com.global.userlistapplication.data

import javax.inject.Inject

class PersonLocalDataSource @Inject constructor() {

    private var dataSource = DataSource()

    fun fetchPersonList(
        next: String?,
        completionHandler: FetchCompletionHandler
    ) {
        dataSource.fetch(next, completionHandler)

    }

}
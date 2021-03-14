package com.global.userlistapplication.data

import android.util.Log
import com.global.userlistapplication.common.Resource
import javax.inject.Inject


typealias ResourceHandler = (Resource<Any>?) -> Unit

class PersonRepository @Inject constructor(private val localDataSource: PersonLocalDataSource) {

    fun fetchPersonList(next: String?, resourceHandler: ResourceHandler) {
        resourceHandler(Resource.Loading)
        Log.d("YUSUF_DEBUG", "Loading")
        localDataSource.fetchPersonList(next, completionHandler = { fetchResponse, fetchError ->

            if (fetchResponse == null) {
                Log.d("YUSUF_DEBUG", "error occured -> " + fetchError?.errorDescription)
                resourceHandler(Resource.Error(Exception(fetchError?.errorDescription)))
            } else {
                Log.d("YUSUF_DEBUG", "Data fetched")
                resourceHandler(Resource.Success(fetchResponse))
            }
        })
    }
}
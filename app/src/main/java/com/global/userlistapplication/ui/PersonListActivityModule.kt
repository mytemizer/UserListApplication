package com.global.userlistapplication.ui

import com.global.userlistapplication.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class PersonListActivityModule {

    @ActivityScope
    @get:Provides
    val personListAdapter = PersonListAdapter()

}
package com.global.userlistapplication.di.module

import com.global.userlistapplication.ui.PersonListActivityModule
import com.global.userlistapplication.ui.PersonListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector(modules = [PersonListActivityModule::class])
    abstract fun personListFragment(): PersonListFragment?

}
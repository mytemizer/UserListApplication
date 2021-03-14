package com.global.userlistapplication.di.module

import com.global.userlistapplication.MainActivity
import com.global.userlistapplication.di.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBuilderModule {

    @ActivityScope
    @get:ContributesAndroidInjector
    val mainActivity: MainActivity
}
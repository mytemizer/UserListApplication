package com.global.userlistapplication.di.component

import android.content.Context
import com.global.userlistapplication.App
import com.global.userlistapplication.di.module.ActivityBuilderModule
import com.global.userlistapplication.di.module.FragmentModule
import com.global.userlistapplication.di.module.ViewModelModule
import com.global.userlistapplication.ui.PersonListActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        PersonListActivityModule::class,
        ActivityBuilderModule::class,
        ViewModelModule::class,
        FragmentModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AndroidInjector<App>
    }
}
package com.global.userlistapplication.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.icanteach.projectx.common.di.key.ViewModelKey
import com.global.userlistapplication.di.ViewModelFactory
import com.global.userlistapplication.ui.PersonListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @get:IntoMap
    @get:Binds
    @get:ViewModelKey(PersonListViewModel::class)
    val PersonListViewModel.personListViewModel: ViewModel

    @get:Binds
    val ViewModelFactory.viewModelFactory: ViewModelProvider.Factory
}
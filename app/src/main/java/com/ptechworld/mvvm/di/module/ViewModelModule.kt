package com.ptechworld.mvvm.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ptechworld.mvvm.viewmodel.RepoViewModel
import com.ptechworld.mvvm.viewmodel.ViewModelFactory
import com.ptechworld.mvvm.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    /*
     * This method basically says
     * inject this object into a Map using the @IntoMap annotation,
     * with the  MovieListViewModel.class as key,
     * and a Provider that will build a MovieListViewModel
     * object.
     *
     * */

    @Binds
    @IntoMap
    @ViewModelKey(RepoViewModel::class)
    protected abstract fun repoViewModel(repoViewModel: RepoViewModel): ViewModel
}
package com.tokovenko.zimad.di.modules;

import androidx.lifecycle.ViewModel;
import com.tokovenko.zimad.di.ViewModelKey;
import com.tokovenko.zimad.presentation.viewmodels.CatsListViewModel;
import com.tokovenko.zimad.presentation.viewmodels.DogsListViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CatsListViewModel.class)
    abstract ViewModel catsListViewModel(CatsListViewModel catsListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(DogsListViewModel.class)
    abstract ViewModel dogsListViewModel(DogsListViewModel dogsListViewModel);
}

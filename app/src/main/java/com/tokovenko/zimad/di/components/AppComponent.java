package com.tokovenko.zimad.di.components;

import android.app.Application;

import com.tokovenko.zimad.App;
import com.tokovenko.zimad.di.modules.RepositoryModule;
import com.tokovenko.zimad.di.modules.ViewModelModule;
import com.tokovenko.zimad.presentation.BaseFragment;
import com.tokovenko.zimad.presentation.CatsListFragment;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {RepositoryModule.class, ViewModelModule.class})
public interface AppComponent {

    void inject(BaseFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder application(Application application);
        AppComponent build();
    }
}

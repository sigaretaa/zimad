package com.tokovenko.zimad;

import android.app.Application;

import com.tokovenko.zimad.di.components.AppComponent;
import com.tokovenko.zimad.di.components.DaggerAppComponent;

import timber.log.Timber;

public class App extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

        initAppComponent();
    }

    private void initAppComponent(){
        appComponent = DaggerAppComponent
                .builder()
                .application(this)
                .build();
    }

    public static AppComponent getAppComponent(){
        return appComponent;
    }
}

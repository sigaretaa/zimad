package com.tokovenko.zimad.presentation.viewmodels;

import androidx.lifecycle.ViewModel;

import com.tokovenko.zimad.data.repositories.Repository;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseViewmodel extends ViewModel {

    private final CompositeDisposable disposables = new CompositeDisposable();
    protected final Repository repository;

    public BaseViewmodel(Repository repository){
        this.repository = repository;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.dispose();
    }

    protected void adddDisposable(Disposable d){
        disposables.add(d);
    }
}

package com.tokovenko.zimad.presentation.viewmodels;

import com.tokovenko.zimad.data.repositories.Repository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DogsListViewModel extends AnimalListViewModel {

    @Inject
    public DogsListViewModel(Repository repository) {
        super(repository);
    }

    @Override
    public void reloadList() {
        adddDisposable(repository.getDogs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(animals -> setDate(animals),
                        throwable -> setError(throwable)));
    }
}

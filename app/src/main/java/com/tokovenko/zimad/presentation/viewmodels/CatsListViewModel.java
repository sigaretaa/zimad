package com.tokovenko.zimad.presentation.viewmodels;

import com.tokovenko.zimad.data.repositories.Repository;
import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CatsListViewModel extends AnimalListViewModel {

    @Inject
    public CatsListViewModel(Repository repository) {
        super(repository);
    }

    @Override
    public void reloadList() {
        adddDisposable(repository.getCats()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        .subscribe(animals -> setDate(animals),
                   throwable -> setError(throwable)));
    }
}

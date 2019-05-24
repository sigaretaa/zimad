package com.tokovenko.zimad.presentation.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tokovenko.zimad.data.repositories.Repository;
import com.tokovenko.zimad.domain.model.Animal;

import java.util.List;

import javax.inject.Inject;

public class AnimalListViewModel extends BaseViewmodel {

    private final MutableLiveData<List<Animal>> animalsListLiveData;
    private final MutableLiveData<Throwable> throwableLiveData;

    @Inject
    public AnimalListViewModel(Repository repository) {
        super(repository);
        animalsListLiveData = new MutableLiveData<>();
        throwableLiveData = new MutableLiveData<>();
        reloadList();
    }

    public void reloadList(){}

    public void setDate(List<Animal> animalList){
        animalsListLiveData.postValue(animalList);
    }

    public void setError(Throwable throwable){
        throwableLiveData.postValue(throwable);
    }

    public LiveData<List<Animal>> getAnimalsListLiveData() {
        return animalsListLiveData;
    }

    public MutableLiveData<Throwable> getThrowableLiveData() {
        return throwableLiveData;
    }
}

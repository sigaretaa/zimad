package com.tokovenko.zimad.data.store;

import com.tokovenko.zimad.api.AnimalApi;
import com.tokovenko.zimad.api.response.AnimalsResponce;
import com.tokovenko.zimad.domain.model.Animal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.reactivex.Single;
import timber.log.Timber;

public class RemoteStore {

    private final AnimalApi api;

    public RemoteStore(AnimalApi api){
        this.api = api;
    }

    public Single<List<Animal>> getCats() {
        return api.getAnimalsList("cat")
                .map(AnimalsResponce::getData);
    }

    public Single<List<Animal>> getDogs() {
        return api.getAnimalsList("dog")
                .map(AnimalsResponce::getData);
    }
}

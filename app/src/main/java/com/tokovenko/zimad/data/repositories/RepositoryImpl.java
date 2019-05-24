package com.tokovenko.zimad.data.repositories;

import com.tokovenko.zimad.data.store.RemoteStore;
import com.tokovenko.zimad.domain.model.Animal;

import java.util.List;

import io.reactivex.Single;

public class RepositoryImpl implements Repository{

    private RemoteStore remoteStore;

    public RepositoryImpl(RemoteStore remoteStore){
        this.remoteStore = remoteStore;
    }

    @Override
    public Single<List<Animal>> getCats() {
        return remoteStore.getCats();
    }

    @Override
    public Single<List<Animal>> getDogs() {
        return remoteStore.getDogs();
    }
}

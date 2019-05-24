package com.tokovenko.zimad.data.repositories;

import com.tokovenko.zimad.domain.model.Animal;

import java.util.List;

import io.reactivex.Single;

public interface Repository {
    Single<List<Animal>> getCats();
    Single<List<Animal>> getDogs();
}

package com.tokovenko.zimad.api;


import com.tokovenko.zimad.api.response.AnimalsResponce;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AnimalApi {
    @GET("xim/api.php/")
    Single<AnimalsResponce> getAnimalsList(@Query("query") String animal);
}

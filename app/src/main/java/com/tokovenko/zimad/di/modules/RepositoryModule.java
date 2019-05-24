package com.tokovenko.zimad.di.modules;

import androidx.annotation.NonNull;

import com.tokovenko.zimad.api.AnimalApi;
import com.tokovenko.zimad.data.repositories.Repository;
import com.tokovenko.zimad.data.repositories.RepositoryImpl;
import com.tokovenko.zimad.data.store.RemoteStore;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Module
public class RepositoryModule {

    private static final String BASE_URL = "http://kot3.com/";

    @Provides
    @Singleton
    @NonNull
    OkHttpClient.Builder provideOkHttp() {
        return new OkHttpClient.Builder();
    }

    @Provides
    @Singleton
    @NonNull
    Retrofit provideRetrofit(OkHttpClient.Builder httpClient) {
        //add logger
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);

        Retrofit.Builder retroBuilder= new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create());

        retroBuilder.client(httpClient.build());
        return retroBuilder.build();
    }

    // API
    @Provides
    @Singleton
    @NonNull
    AnimalApi provideAnimalApi(Retrofit retrofit) {
        return retrofit.create(AnimalApi.class);
    }

    // Store
    @Provides
    @Singleton
    @NonNull
    RemoteStore provideRemoteStore(AnimalApi api) {
        return new RemoteStore(api);
    }

    // Repository
    @Provides
    @Singleton
    @NonNull
    Repository provideRepository(RemoteStore remoteStore) {
        return new RepositoryImpl(remoteStore);
    }

}

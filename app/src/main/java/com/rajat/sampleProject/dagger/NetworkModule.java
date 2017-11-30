package com.rajat.sampleProject.dagger;

import com.rajat.sampleProject.apis.Api;
import com.rajat.sampleProject.utilities.Constants;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Raj on 25/11/17.
 */

@Module
public class NetworkModule {

    private static final String NAME_BASE_URL = "NAME_BASE_URL";
    @Provides
    @Named(NAME_BASE_URL)
    String provideBaseUrlString() {
        return Constants.HOST;
    }

    @Provides
    @Singleton
    Converter.Factory provideGsonConverter() {
        return GsonConverterFactory.create();
    }


    @Provides
    @Singleton
    CallAdapter.Factory provideRxCallAdapter(){
        return RxJava2CallAdapterFactory.create();
    }


    @Provides
    @Singleton
    Retrofit provideRetrofit(Converter.Factory converter, @Named(NAME_BASE_URL) String baseUrl, CallAdapter.Factory callFactory) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converter)
                .addCallAdapterFactory(callFactory)
                .build();
    }

    @Provides
    @Singleton
    Api provideUsdaApi(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }

}

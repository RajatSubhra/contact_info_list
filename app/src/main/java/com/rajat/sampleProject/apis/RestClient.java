package com.rajat.sampleProject.apis;

import com.rajat.sampleProject.utilities.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    public Api getApis(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(Constants.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Api.class);
    }
}

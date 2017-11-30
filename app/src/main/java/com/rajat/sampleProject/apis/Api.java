package com.rajat.sampleProject.apis;

import com.rajat.sampleProject.models.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {

    @GET("/users")
    Observable<List<User>> getAllUsers();
}

package com.example.fragments.networking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apiinterface {
    @GET("api")
    Call<com.example.fragments.models.UsersResponse> getSingleUser();

    @GET("api")
    Call<com.example.fragments.models.UsersResponse> getMultipleUser(@Query("results") int count);
}

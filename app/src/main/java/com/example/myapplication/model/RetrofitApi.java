package com.example.myapplication.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitApi {

    @POST("/searches")
    Call<Void> createPost(@Body Recherche recherche);

    @GET("/all")
    Call<List<Recherche>> getRecherche();

    @POST("/give")
    Call<Void> createGive(@Body Don don);

    @POST("/messages")
    Call<Void> createMessage(@Body ReceiveMessage receiveMessage);

}

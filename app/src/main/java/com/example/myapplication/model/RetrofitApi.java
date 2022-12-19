package com.example.myapplication.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitApi {

@POST("Search")
Call<Recherche> createPost(@Body Recherche recherche);

@GET("all")
Call<List<Recherche>> getRecherche();

}

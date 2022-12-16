package com.example.myapplication.model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitApi {
@POST("recherche")


Call<Recherche> createPost(@Body Recherche recherche);
}

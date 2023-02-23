package com.pmdm.virgen.pueblosconnavigationdraweb;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @GET("users/{id}")
    Call<Usuario> getUser(@Path("id") int id);


    @POST("users")
    Call<Usuario> createUser(@Body Usuario user);

    //callback crear user

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.example.com/")
            .build();

    ApiService apiService = retrofit.create(ApiService.class);

}

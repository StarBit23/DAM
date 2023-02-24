package com.pmdm.virgen.pueblosconnavigationdraweb;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("user")
    Call<Usuario> getUser(@Query("id") int id);

    @POST("registro")
    Call<ResponseRegister> createUser(@Body Usuario user);

    @POST("/auth")
    Call<Usuario> tokenUser(@Body Usuario user);
    //callback crear user

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:80/api-pueblos/endp/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    ApiService apiService = retrofit.create(ApiService.class);

}

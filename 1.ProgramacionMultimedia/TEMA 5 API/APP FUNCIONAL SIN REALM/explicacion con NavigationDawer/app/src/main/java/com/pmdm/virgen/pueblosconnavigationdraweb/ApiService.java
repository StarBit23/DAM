package com.pmdm.virgen.pueblosconnavigationdraweb;

import com.pmdm.virgen.pueblosconnavigationdraweb.responses.ResponseAuth;
import com.pmdm.virgen.pueblosconnavigationdraweb.responses.ResponseListadoJuegos;
import com.pmdm.virgen.pueblosconnavigationdraweb.responses.ResponseRegister;
import com.pmdm.virgen.pueblosconnavigationdraweb.varios.ClaseGetToken;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @POST("registro")
    Call<ResponseRegister> createUser(@Body Usuario user);

    @POST("auth")
    Call<ResponseAuth> getToken(@Body ClaseGetToken claseGetToken);
    //callback crear user

    @GET("pueblo")
    Call<ResponseListadoJuegos> getListJuego(@Query("api-key") String apikey);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:80/api-pueblos/endp/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    ApiService apiService = retrofit.create(ApiService.class);

}

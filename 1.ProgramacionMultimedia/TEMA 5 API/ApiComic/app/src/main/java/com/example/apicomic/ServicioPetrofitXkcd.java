package com.example.apicomic;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ServicioPetrofitXkcd {
    @GET("{idComic}/info.0.json")
    Call<Comic> dameComic(@Path("idComic") int idComic);

}


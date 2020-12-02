package com.example.mympvpjson.model.repositori;

import com.example.mympvpjson.model.WisataResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRest {
    @GET("/api/purwakarta/wisata")
    Call<WisataResponse> getWisataList();
}

package com.example.flowergallaryapibased.flower;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlowerServiceApi {

    @GET("feeds/flowers.json")
    Call<List<FlowerResponse>> getAllFlower();
}

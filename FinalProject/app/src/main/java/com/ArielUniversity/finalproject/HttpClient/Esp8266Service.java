package com.ArielUniversity.finalproject.HttpClient;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.GET;

public interface Esp8266Service {

    @POST("/On")
    Call<MyResponse> TurnSwitchOn(@Body EmptyRequest request);

    @POST("/Off")
    Call<MyResponse> TurnSwitchOff(@Body EmptyRequest request);

    @GET("/GetTemp")
    Call<String> GetTemperature();
}

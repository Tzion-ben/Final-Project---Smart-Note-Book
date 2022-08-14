package com.ArielUniversity.finalproject.HttpClient;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Esp8266Service {

    @POST("/On")
    Call<MyResponse> createPostRequest(@Body EmptyRequest request);

}

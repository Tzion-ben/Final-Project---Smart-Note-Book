package com.ArielUniversity.finalproject.Models.Activation_Model;

import static io.realm.mongodb.ErrorCode.Type.JSON;


import android.util.Log;

import com.ArielUniversity.finalproject.HttpClient.EmptyRequest;
import com.ArielUniversity.finalproject.HttpClient.Esp8266Service;
import com.ArielUniversity.finalproject.HttpClient.MyResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Smart_Switch_Client_Instance {

    private final String  _URL="http://192.168.1.109/";

    public Smart_Switch_Client_Instance(){

    }
    
    public void TurnSmartSwitchOnAndOff(String state) throws IOException {

        switch(state)
        {
            case "Off":
            {
                TurnSwitchOff();
            }
            case "On":
            {
                TurnSwitchOn();
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + state);
        }
    }

    private String TurnSwitchOn() throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(this._URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Esp8266Service service = retrofit.create(Esp8266Service.class);

        Call<MyResponse> call = service.createPostRequest(EmptyRequest.INSTANCE);

        // on below line we are executing our method.
        call.enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                // this method is called when we get response from our api.
                Log.d("","succes");
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {
                // setting text to our text view when
                // we get error response from API.
                Log.d("","fail");
            }
        });

        return null;
    }


    private static void TurnSwitchOff() {
    }
}

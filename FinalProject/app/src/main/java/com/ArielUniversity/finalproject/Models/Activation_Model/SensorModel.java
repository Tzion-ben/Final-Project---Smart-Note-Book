package com.ArielUniversity.finalproject.Models.Activation_Model;


import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ArielUniversity.finalproject.DataObjects.UserObj;
import com.ArielUniversity.finalproject.HttpClient.EmptyRequest;
import com.ArielUniversity.finalproject.HttpClient.Esp8266Service;
import com.ArielUniversity.finalproject.HttpClient.MyResponse;

import java.io.IOException;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class SensorModel  extends AppCompatActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    /*
        * Hashmap will contain the sensor data. The key will be the sensor id - value will be the real
        * sensor data
    */

    private Map<String,Integer> sensors_data_map = new HashMap<>();

    /*
    * Listener function that will listen to the cloud for data and will put the data into the variable
    * The function will output the variable <sensors_data_map> with the sensors data.
    * After invoking the data from the sensors, we searching for the sensor id in the enum class and get sensor number
    * After we know which sensors is this we send the name/enum/id to the DB and find the relations of the sensor
    * the DB model will returns a array/list of the relations of the sensor. We loop through the container
    * and activate every function according to the relation.
    */



    /*
        There will be list of features functions according to each feature. We will try to make these
        as generic as we can
     */

    private final String  _URL="http://192.168.1.109/";



    public void TurnSmartSwitchOnAndOff(String state) throws IOException {

        switch(state)
        {
            case "Off":
            {
                TurnSwitchOff();
                break;
            }
            case "On":
            {
                TurnSwitchOn();
                break;
            }

            default:
                throw new IllegalStateException("Unexpected value: " + state);
        }
    }

    private String TurnSwitchOn() throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(this._URL +"On/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Esp8266Service service = retrofit.create(Esp8266Service.class);

        Call<MyResponse> call = service.TurnSwitchOn(EmptyRequest.INSTANCE);

        // on below line we are executing our method.
        call.enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                // this method is called when we get response from our api.
                Log.d("","success to switch up electricity");
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {
                // setting text to our text view when
                // we get error response from API.
                Log.d("","fail to switch up electricity");
            }
        });

        return null;
    }


    private String TurnSwitchOff() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(this._URL + "Off/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Esp8266Service service = retrofit.create(Esp8266Service.class);

        Call<MyResponse> call = service.TurnSwitchOff(EmptyRequest.INSTANCE);

        // on below line we are executing our method.
        call.enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                // this method is called when we get response from our api.
                Log.d("","success to switch down electricity");
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {
                // setting text to our text view when
                // we get error response from API.
                Log.d("","fail to switch down electricity");
            }
        });

        return null;
    }

    public float GetTemperature() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(this._URL +"GetTemp/")
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        Esp8266Service service = retrofit.create(Esp8266Service.class);

        Call<String> call = service.GetTemperature();


        // on below line we are executing our method.
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                // this method is called when we get response from our api.
                Log.d("","success");
                System.out.println("Temperature is :" + response.body());

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                // setting text to our text view when
                // we get error response from API.
                Log.d("","fail to read temperature");
            }
        });

        return 24.0F;
    }

    public void MonitorTemperature() throws IOException {
        //Check user preference to see if this feature is on . Also check temperatue limit from DB
        float limit = 22.0F;
        if(limit < this.GetTemperature())
        {
            this.TurnSwitchOn();
        }
        else
        {
            this.TurnSwitchOff();
        }
    }


}

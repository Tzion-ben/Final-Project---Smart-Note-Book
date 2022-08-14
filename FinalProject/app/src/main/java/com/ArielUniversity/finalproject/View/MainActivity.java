package com.ArielUniversity.finalproject.View;
/***
 * This class is the Main entry to our app
 */

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;

import com.ArielUniversity.finalproject.Models.Activation_Model.SensorModel;
import com.ArielUniversity.finalproject.Models.Activation_Model.Smart_Switch_Client_Instance;
import com.ArielUniversity.finalproject.R;
import com.ArielUniversity.finalproject.View.EntryActivities.*;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalTime;

public class MainActivity extends AppCompatActivity {

    Context context = this;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Smart_Switch_Client_Instance SSCI= new Smart_Switch_Client_Instance();
        try {
            SSCI.TurnSmartSwitchOnAndOff("Off");
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*lead to activity to create a new user*/
        findViewById(R.id.id_register_button).setOnClickListener(view -> {
            startActivity(new Intent(this, com.ArielUniversity.finalproject.View.EntryActivities.RegisterActivity.class));
        });

        /*lead to activity for existing user*/
        findViewById(R.id.id_login_button).setOnClickListener(view -> {
            startActivity(new Intent(this, LoginActivity.class));
        });
    }

    private void runShellCommand(String command) throws Exception {
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
    }


}
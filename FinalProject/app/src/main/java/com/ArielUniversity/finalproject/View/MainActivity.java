package com.ArielUniversity.finalproject.View;
/***
 * This class is the Main entry to our app
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.ArielUniversity.finalproject.R;
import com.ArielUniversity.finalproject.View.EntryActivities.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*lead to activity to create a new user*/
        findViewById(R.id.id_register_button).setOnClickListener(view -> {
            startActivity(new Intent(this, com.ArielUniversity.finalproject.View.EntryActivities.RegisterActivity.class));
        });

        /*lead to activity for existing user*/
        findViewById(R.id.id_login_button).setOnClickListener(view -> {
            startActivity(new Intent(this, LoginActivity.class));
        });
    }
}
package com.example.finalproject.View;
/***
 * This class is the Main entry to our app
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.finalproject.AccessDB.DB_CRUD;
import com.example.finalproject.R;
import com.example.finalproject.View.EntryActivities.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DB_CRUD db_crud =new DB_CRUD();
//        db_crud.write_user_preferance_to_db(new UserObj("Yossi","2222","2222","Yosi@mail.com"));

        /*lead to activity to create a new user*/
        findViewById(R.id.id_register_button).setOnClickListener(view -> {
            startActivity(new Intent(this, com.example.finalproject.View.EntryActivities.RegisterActivity.class));
        });

        /*lead to activity for existing user*/
        findViewById(R.id.id_login_button).setOnClickListener(view -> {
            startActivity(new Intent(this, LoginActivity.class));
        });
    }
}
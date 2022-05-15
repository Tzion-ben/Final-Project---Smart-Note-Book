package com.example.finalproject.EntryActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.finalproject.R;

public class LoginActivity extends AppCompatActivity {
    private EditText passwordInput, nameInput, idInput, emailInput;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        passwordInput = (EditText) findViewById(R.id.id_password_input_login);
        nameInput = (EditText) findViewById(R.id.id_name_input_login);
        idInput = (EditText) findViewById(R.id.id_id_input_login);
        emailInput = (EditText) findViewById(R.id.id_email_input_login);

        loginButton = (Button) findViewById(R.id.id_button_login);
    }
}
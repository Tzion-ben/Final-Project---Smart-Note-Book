package com.example.finalproject.View.EntryActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.finalproject.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText passwordInput, idInput, emailInput;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        passwordInput = (EditText) findViewById(R.id.id_password_input_register);
        idInput = (EditText) findViewById(R.id.id_id_input_register);
        emailInput = (EditText) findViewById(R.id.id_email_input_register);
        registerButton = (Button) findViewById(R.id.id_button_register);
        
    }
}
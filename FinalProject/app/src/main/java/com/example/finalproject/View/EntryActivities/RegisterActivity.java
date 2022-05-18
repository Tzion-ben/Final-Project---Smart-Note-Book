package com.example.finalproject.View.EntryActivities;
/**
 * This Activity will \
 */

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.finalproject.AccessDB.DBInstance;
import com.example.finalproject.AccessDB.DB_CRUD;
import com.example.finalproject.DataObjects.UserObj;
import com.example.finalproject.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText passwordInput, idInput, emailInput, nameInput;
    private Button registerButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        passwordInput = (EditText) findViewById(R.id.id_password_input_register);
        idInput = (EditText) findViewById(R.id.id_id_input_register);
        emailInput = (EditText) findViewById(R.id.id_email_input_register);
        nameInput = (EditText) findViewById(R.id.id_name_input_register);

        String password = passwordInput.getText().toString();
        String id = idInput.getText().toString();
        String email = emailInput.getText().toString();
        String name = nameInput.getText().toString();

        UserObj user = new UserObj(name, id, password, email);

        registerButton = (Button) findViewById(R.id.id_button_register);
        backButton = (Button) findViewById(R.id.id_back_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUserInDB(user);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });
    }

    /*save new user preferences to the DB*/
    private void saveUserInDB(UserObj newUser){
        DB_CRUD.Create_New_User_Preference(newUser);
        goBack();
    }

    /*go back to main entry to the app activity*/
    private void goBack(){
        Intent intent = new Intent(this, com.example.finalproject.View.MainActivity.class);
        startActivity(intent);
    }
}
package com.ArielUniversity.finalproject.View.EntryActivities;
/**
 * This Activity will \
 */

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ArielUniversity.finalproject.AccessDB.DB_CRUD;
import com.ArielUniversity.finalproject.DataObjects.UserObj;
import com.ArielUniversity.finalproject.R;
import com.ArielUniversity.finalproject.Tools.Validation;

public class RegisterActivity extends AppCompatActivity {
    private EditText passwordInput, idInput, emailInput, nameInput;
    private Button registerButton;

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

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUserInDB(user);
            }
        });

        findViewById(R.id.id_back_button).setOnClickListener(view -> {
            startActivity(new Intent(this, com.ArielUniversity.finalproject.View.MainActivity.class));
        });
    }

    /*save new user preferences to the DB*/
    private void saveUserInDB(UserObj newUser){
        if(!Validation.isInputValid(newUser.getName(), newUser.getPassword(), newUser.getId(), newUser.getEmail(),
                nameInput, passwordInput, idInput, emailInput)){
            Toast.makeText(RegisterActivity.this,
                    "נסה שנית", Toast.LENGTH_SHORT).show();
            return;
        }

        DB_CRUD.createNewUser(newUser);
        goBack();
    }

    /*go back to main entry to the app activity*/
    private void goBack(){
        Intent intent = new Intent(this, com.ArielUniversity.finalproject.View.MainActivity.class);
        startActivity(intent);
    }
}
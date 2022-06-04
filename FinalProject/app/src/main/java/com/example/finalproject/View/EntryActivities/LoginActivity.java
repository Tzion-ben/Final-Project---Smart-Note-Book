package com.example.finalproject.View.EntryActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalproject.AccessDB.DBInstance;
import com.example.finalproject.AccessDB.DB_CRUD;
import com.example.finalproject.DataObjects.UserObj;
import com.example.finalproject.R;
import com.example.finalproject.Tools.Validation;
import com.example.finalproject.View.UserActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    private EditText passwordInput, nameInput, idInput, emailInput;
    private Button loginButton;
    private final String tagActivities = "ACTIVITIES";
    private final String tagUser = "USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        passwordInput = (EditText) findViewById(R.id.id_password_input_login);
        nameInput = (EditText) findViewById(R.id.id_name_input_login);
        idInput = (EditText) findViewById(R.id.id_id_input_login);
        emailInput = (EditText) findViewById(R.id.id_email_input_login);

        String password = passwordInput.getText().toString();
        String id = idInput.getText().toString();
        String email = emailInput.getText().toString();
        String name = nameInput.getText().toString();

        UserObj user = new UserObj(name, id, password, email);

        // activities from DB_CRUD
        HashMap<String, Integer> preference_activities = DB_CRUD.Get_User_Preference(user, "1");
        loginButton = (Button) findViewById(R.id.id_button_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUserActivity(user, preference_activities);
            }
        });

        /*go back to main activity*/
        findViewById(R.id.id_back_button).setOnClickListener(view -> {
            startActivity(new Intent(this, com.example.finalproject.View.MainActivity.class));
        });
    }

    private void goToUserActivity(UserObj user, HashMap<String, Integer> preference_activities){

        if(!Validation.isInputValid(user.getName(), user.getPassword(), user.getId(), user.getEmail(),
                nameInput, passwordInput, idInput, emailInput)) {
            Toast.makeText(LoginActivity.this,
                    "נסה שנית", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!Validation.isSameIdAndPassword(user)){
            Toast.makeText(LoginActivity.this,
                    "סיסמא או ת.ז שגויים, אנא נסו שנית", Toast.LENGTH_SHORT).show();
            return;
        }

        // send user and list of activities to "UserActivity"
        Intent user_intent = new Intent(this, com.example.finalproject.View.UserActivity.class);

        user_intent.putExtra(tagUser,  (Serializable) user);
        user_intent.putExtra(tagActivities, preference_activities);

        startActivity(user_intent);

    }
}
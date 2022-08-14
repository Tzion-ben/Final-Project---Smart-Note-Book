package com.ArielUniversity.finalproject.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.ArielUniversity.finalproject.AccessDB.DB_CRUD;
import com.ArielUniversity.finalproject.DataObjects.UserObj;
import com.ArielUniversity.finalproject.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserActivity extends AppCompatActivity implements Serializable {
    private Button updateButton;
    private EditText user_name;
    private ListView checkBoxes;
    private HashMap<String, String> preference_activities;
    private UserObj user;

    private final String tagActivities = "ACTIVITIES";
    private final String tagUser = "USER";
    private final String TRUE                              =                   "1";
    private final String FALSE                             =                   "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        //user & HashMap<String, Integer> nameActivity => from last activity
        preference_activities = (HashMap<String, String>) getIntent().getSerializableExtra(tagActivities);
        user = (UserObj) getIntent().getSerializableExtra(tagUser);

        String name = user.getName();
        user_name = (EditText) findViewById(R.id.id_editText);
        user_name.setText(name);

        updateButton = (Button) findViewById(R.id.id_update_button);
        checkBoxes = (ListView) findViewById(R.id.id_list_checkBox);

        ArrayList<String> items = new ArrayList<>();
        for(Map.Entry<String, String> item :preference_activities.entrySet()){
            String key = item.getKey();
            items.add(key);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, items);

        checkBoxes.setAdapter(adapter);

        ArrayList<String> selected_item = new ArrayList<>();
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String itemSelected = "Selected items:\n";
                for (int i = 0; i < checkBoxes.getCount(); i++) {
                    if (checkBoxes.isItemChecked(i)) {
                        String nameItem = checkBoxes.getItemAtPosition(i).toString();
                        itemSelected += nameItem + "\n";
                        selected_item.add(nameItem);
                    }
                }
                Toast.makeText(UserActivity.this,
                        itemSelected, Toast.LENGTH_SHORT).show();

                updateUserChoices(user, selected_item);

            }
        });
    }

    private void updateUserChoices(UserObj user, ArrayList<String> selected_item) {
        int i=0;
        for(Map.Entry<String, String> item : preference_activities.entrySet()){

            if(i > selected_item.size() - 1){
                item.setValue(FALSE);
                continue;
            }

            // else..
            String key = item.getKey();
            if(key.equals(selected_item.get(i))){
                item.setValue(TRUE);
                i++;
            }
            else
                item.setValue(FALSE);
        }

        DB_CRUD.update_user_preference_to_db(user, preference_activities);
    }

}
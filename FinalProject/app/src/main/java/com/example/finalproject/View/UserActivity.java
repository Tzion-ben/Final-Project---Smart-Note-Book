package com.example.finalproject.View;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.finalproject.R;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {
    private Button updateButton;
    private EditText user_name;
    private String name, user_id;
    private ListView checkBoxes;
    private List<String> nameActivity;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> selected_item_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);



        //user & List<String> nameActivity => from last activity
        Intent institute_details = getIntent();
        user_id = institute_details.getExtras().getString("user_id");
        name = institute_details.getExtras().getString("user_name");
        user_name = (EditText) findViewById(R.id.id_editText);
        user_name.setText(name);

        updateButton = (Button) findViewById(R.id.id_update_button);
        checkBoxes = (ListView) findViewById(R.id.id_list_checkBox);

        selected_item_result = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, nameActivity);

        checkBoxes.setAdapter(adapter);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String itemSelected = "Selected items:\n";
                for (int i = 0; i < checkBoxes.getCount(); i++) {
                    if (checkBoxes.isItemChecked(i)) {
                        String nameItem = checkBoxes.getItemAtPosition(i).toString();
                        itemSelected += nameItem + "\n";
                        selected_item_result.add(nameItem);
                    }
                }
                Toast.makeText(UserActivity.this,
                        itemSelected, Toast.LENGTH_SHORT).show();

                returnResult();

            }
        });
    }

    private void returnResult(){
//        Intent return_res = new Intent(this, WatchingQueueActivity.class);
//        return_res.putExtra("user_id", user_id);
//        return_res.putStringArrayListExtra("result", selected_item_result);
//        startActivity(return_res);
    }
}
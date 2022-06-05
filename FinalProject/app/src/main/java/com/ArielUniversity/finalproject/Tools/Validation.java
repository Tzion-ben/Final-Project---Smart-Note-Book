package com.ArielUniversity.finalproject.Tools;

import android.text.TextUtils;
import android.widget.EditText;

import com.ArielUniversity.finalproject.AccessDB.DB_CRUD;
import com.ArielUniversity.finalproject.DataObjects.UserObj;

public class Validation {

    public static boolean isSameIdAndPassword(UserObj user){
        UserObj tempUser = DB_CRUD.Get_User_Data(user.getId());

        if(!tempUser.getPassword().equals(user.getPassword()))
            return false;

        if(!tempUser.getEmail().equals(user.getEmail()))
            return false;

        return true;
    }
    public static boolean isInputValid(String userName, String password, String id, String email,
                                            EditText userName_Input, EditText password_input, EditText id_input, EditText email_input){
        if (TextUtils.isEmpty(userName)) {
            userName_Input.setError("שם משתמש הוא שדה חובה");
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            password_input.setError("סיסמא הוא שדה חובה");
            return false;
        }

        if (password.length() < 9) {
            password_input.setError("אורך הסיסמא חייב להיות באורך 9 תווים לפחות");
            return false;
        }
        if (id.length() < 9) {
            id_input.setError("ת.ז. שגויה");
            return false;
        }

        if (!email.contains("@")) {
            email_input.setError("מייל חייב להכיל @");
            return false;
        }
        return true;
    }
}

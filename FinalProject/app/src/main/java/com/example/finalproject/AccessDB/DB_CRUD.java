package com.example.finalproject.AccessDB;
/**
 *
 */

import com.example.finalproject.DataObjects.UserObj;
import java.util.HashMap;

public class DB_CRUD {

    public static void write_user_preferance_to_db(UserObj userObj, HashMap<String,Integer> pref)
    {
//        Realm.getInstanceAsync(this._config, new Realm.Callback() {
//            @Override
//            public void onSuccess(Realm realm) {
//                Log.v(
//                        "EXAMPLE",
//                        "Successfully opened a realm with reads and writes allowed on the UI thread."
//
//                );
//
//            }
//        });
//
//        REALM_INSTANCE.getRealmInstance().executeTransaction(transactionRealm -> {
//            transactionRealm.insert(userObj);
//        });

    }

    /*get user preference about the sensors*/
    public static HashMap<String,Integer> Get_User_Preference(UserObj userObj, String feature_id)
    {
        DBInstance REALM_INSTANCE = DBInstance.getInstance();/*singleton  instance*/


        return null;
    }

    /*set user preference about the sensors*/
    public static void Create_New_User_Preference(UserObj userObj)
    {
        DBInstance REALM_INSTANCE = DBInstance.getInstance();/*singleton  instance*/

        HashMap<String,Integer> userPreference = new HashMap<String,Integer>();

        REALM_INSTANCE.getRealmInstance().executeTransaction(transactionRealm -> {
            transactionRealm.insert(userObj);
        });
    }

    public static void write_sensor_data(HashMap<String,String> sensorData)
    {
        DBInstance REALM_INSTANCE = DBInstance.getInstance();/*singleton  instance*/


    }

    public static void Get_Sensor_Data(String sensor_id,String Date)
    {
        DBInstance REALM_INSTANCE = DBInstance.getInstance();/*singleton  instance*/


    }

}

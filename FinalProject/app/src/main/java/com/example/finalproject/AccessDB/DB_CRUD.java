package com.example.finalproject.AccessDB;
/**
 * This class will create a Singleton instance of Realm CRUD instance
 */

import android.util.Log;

import com.example.finalproject.DataObjects.UserObj;

import java.util.ArrayList;
import java.util.HashMap;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.mongodb.User;

public class DB_CRUD {
    /**Static variable reference of a single instance of DB_CRUD*/
    private static DB_CRUD     CRUD           = null;

    /**
     * Declaring a variable of type Synchronous Reads and Writes on the UI Thread
     * with realm
     */
    private RealmConfiguration _config        = null;
    public  Realm              _realmInstance = null;

    /**
     * Constructor
     * Here we will be creating private constructor
     * restricted to this class itself
     */
    public DB_CRUD()
    {
        this._config = new RealmConfiguration.Builder()
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .build();
        this._realmInstance = Realm.getInstance(_config);
    }

    public void write_user_preferance_to_db(UserObj userObj, HashMap<String,Integer> pref)
    {
        Realm.getInstanceAsync(this._config, new Realm.Callback() {
            @Override
            public void onSuccess(Realm realm) {
                Log.v(
                        "EXAMPLE",
                        "Successfully opened a realm with reads and writes allowed on the UI thread."

                );

            }
        });

        this._realmInstance.executeTransaction(transactionRealm -> {
                    transactionRealm.insert(userObj);
        });

    }

    public HashMap<String,Integer> Get_User_Preference(UserObj userObj, String feature_id)
    {
        return null;
    }

    public void write_sensor_data(HashMap<String,String> sensorData)
    {

    }

    public void Get_Sensor_Data(String sensor_id,String Date)
    {

    }

    /*Static method*/
    /*Static method to create instance of Singleton class*/
    public static DB_CRUD getInstance()
    {
        if (CRUD == null)
            CRUD = new DB_CRUD();

        return CRUD;
    }


    /*an instance realm */
    public Realm getRealmInstance(){
        return this._realmInstance;
    }
}

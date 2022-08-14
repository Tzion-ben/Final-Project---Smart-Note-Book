package com.ArielUniversity.finalproject.AccessDB;
/**
 *
 */

import android.util.Log;

import com.ArielUniversity.finalproject.DataObjects.UserObj;
import java.util.HashMap;

public class DB_CRUD {

    ///////////////******************************************************************///////////////
    //public static methods region
    public static void write_user_preferance_to_db(UserObj userObj, HashMap<String, Integer> pref)
    {

    }

    /*get user preference about the sensors*/
    public static HashMap<String,Integer> Get_User_Preference(UserObj userObj, String feature_id)
    {
        DBInstance REALM_INSTANCE = DBInstance.getInstance();/*singleton  instance*/


        return null;
    }

    /**WRITE operation:
     * Will write a new user to the realm DB
     * @param userObj
     */
    public static void createNewUser(UserObj userObj)
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

    public static UserObj Get_User_Data(String id){

        return null;
    }
    //end region

    ///////////////******************************************************************///////////////
    //private methods region
    /**
     * Registered new user to the DB
     */
    private static void registerNewUser(String email , String password) {
        DBInstance dbInstance = DBInstance.getInstance();/*singleton  instance*/

        dbInstance.getAppInstance().getEmailPassword().registerUserAsync(email, password, it -> {
            if (it.isSuccess()) {
                Log.i("registerNewUser method", "Successfully registered user.");
            } else {
                Log.e("registerNewUser method", "Failed to register user: " + it.getError().getErrorMessage());
            }
        });
    }

    /**
     * Sent an confirm email to the new user
     */
    /*
    private static void confirmNewUser(){
        DBInstance dbInstance = DBInstance.getInstance();//singleton  instance

        dbInstance.getAppInstance().getEmailPassword().confirmUserAsync(token, tokenId, it -> {
            if (it.isSuccess()) {
                Log.i("EXAMPLE", "Successfully confirmed new user.");
                registerNewUser();
            } else {
                Log.e("EXAMPLE", "Failed to confirm user: " + it.getError().getErrorMessage());
            }
        });

    }
    */
    //end region
}
















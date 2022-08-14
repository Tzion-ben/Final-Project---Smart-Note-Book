package com.ArielUniversity.finalproject.AccessDB;
/**
 *
 */

import android.util.Log;
import android.widget.Toast;

import com.ArielUniversity.finalproject.DataObjects.UserObj;
import com.ArielUniversity.finalproject.StringsManager.StringIDS;

import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.HashMap;

import io.realm.mongodb.App;
import io.realm.mongodb.Credentials;
import io.realm.mongodb.User;
import io.realm.mongodb.mongo.iterable.FindIterable;
import static io.realm.Realm.getApplicationContext;

public class DB_CRUD {

    private static final String USERS_DB                          =               "Users";
    private static final String USERS_REGISTER_DATA_DB_COLLECTION = "Users_Register_Data";
    private static final String MONGODB_ATLAS                     =       "mongodb-atlas";
    private static final String TRUE                              =                   "1";
    private static final String FALSE                             =                   "0";


    ///////////////******************************************************************///////////////
    //public static methods region
    public static void write_user_preference_to_db(UserObj currentUserObj, User currentUserRealm, HashMap<String, String> userPref)
    {
        DBInstance dbInstance = DBInstance.getInstance();/*singleton  instance*/

        dbInstance.setMongoClient(currentUserRealm.getMongoClient(MONGODB_ATLAS));
        dbInstance.setMongoDatabase(dbInstance.getMongoClient().getDatabase(USERS_DB));
        dbInstance.setMongoCollection(dbInstance.getMongoDatabase().getCollection(USERS_REGISTER_DATA_DB_COLLECTION));

        Document newUserPref = new Document().append(currentUserObj.getId() , userPref);

        dbInstance.getMongoCollection().insertOne(newUserPref).getAsync(result -> {
            if(result.isSuccess()){
                Log.v("inserting ","Successfully insert new pref");
            }else{
                Log.v("inserting ","Failed insert new pref"+result.getError().toString());
            }
        });
    }

    public static void update_user_preference_to_db(UserObj currentUserObj, HashMap<String, String> userPref)
    {
//        DBInstance dbInstance = DBInstance.getInstance();/*singleton  instance*/
//
//        dbInstance.setMongoClient(currentUserRealm.getMongoClient(MONGODB_ATLAS));
//        dbInstance.setMongoDatabase(dbInstance.getMongoClient().getDatabase(USERS_DB));
//        dbInstance.setMongoCollection(dbInstance.getMongoDatabase().getCollection(USERS_REGISTER_DATA_DB_COLLECTION));
//
//        Document newUserPref = new Document().append(currentUserObj.getId() , userPref);
//
//        dbInstance.getMongoCollection().insertOne(newUserPref).getAsync(result -> {
//            if(result.isSuccess()){
//                Log.v("inserting ","Successfully insert new pref");
//            }else{
//                Log.v("inserting ","Failed insert new pref"+result.getError().toString());
//            }
//    });
    }

    /*get all user preference */
    public static HashMap<String, String> Get_User_Preference(UserObj userObj){
        return null;
    }

    /*get user preference about a specific sensors*/
    public static boolean Get_User_Preference(UserObj userObj, String feature_id)
    {
        DBInstance REALM_INSTANCE = DBInstance.getInstance();/*singleton  instance*/


        return false;
    }

    /**WRITE operation:
     * Will write a new user to the realm DB
     * @param currentUser
     */
    public static void createNewUser(UserObj currentUser)
    {
        registerNewUser(currentUser);
    }

    public static void write_sensor_data(HashMap<String,String> sensorData)
    {
        DBInstance REALM_INSTANCE = DBInstance.getInstance();/*singleton  instance*/


    }

    public static void Get_Sensor_Data(String sensor_id,String Date)
    {
        DBInstance REALM_INSTANCE = DBInstance.getInstance();/*singleton  instance*/


    }

    public static UserObj Get_User_Data(UserObj currentUserObj , User currentUserRealm){
        DBInstance dbInstance = DBInstance.getInstance();/*singleton  instance*/

        dbInstance.setMongoClient(currentUserRealm.getMongoClient(MONGODB_ATLAS));
        dbInstance.setMongoDatabase(dbInstance.getMongoClient().getDatabase(USERS_DB));
        dbInstance.setMongoCollection(dbInstance.getMongoDatabase().getCollection(USERS_REGISTER_DATA_DB_COLLECTION));

        Document queryFilter = new Document().append(currentUserObj.getId() , currentUserObj);

        dbInstance.getMongoCollection().findOne().getAsync(result -> {
            if(result.isSuccess()){
                Log.v("findOne ","Successfully find one"+result.get().toString());
                Document resDoc = (Document) result.get();
            }else{
                Log.v("findOne ","Failed find one"+result.getError().toString());
            }
        });;

        return null;
    }

    public static UserObj Get_User_Data(UserObj currentUserObj){
//        DBInstance dbInstance = DBInstance.getInstance();/*singleton  instance*/

//        dbInstance.setMongoClient(currentUserRealm.getMongoClient(MONGODB_ATLAS));
//        dbInstance.setMongoDatabase(dbInstance.getMongoClient().getDatabase(USERS_DB));
//        dbInstance.setMongoCollection(dbInstance.getMongoDatabase().getCollection(USERS_REGISTER_DATA_DB_COLLECTION));

//        Document queryFilter = new Document().append(currentUserObj.getId() , currentUserObj);
//        RealmResultTask<Document> currentUserDoc =
//        dbInstance.getMongoCollection().findOne(queryFilter).getAsync(result -> {
//            if(result.isSuccess()){
//                Log.v("inserting ","Successfully insert new pref"+result.get().toString());
//            }else{
//                Log.v("inserting ","Failed insert new pref"+result.getError().toString());
//            }
//        });;

        return null;
    }
    //end region

    ///////////////******************************************************************///////////////
    //private methods region
    /**creating HashMap that will contains all our sensors with start position to false
     * we will use it to config a new registered user**/
    private static HashMap<String, String> createValue() {
        HashMap<String, String> pref = new HashMap<String,String>();
        for (StringIDS.Sensors sensor : StringIDS.Sensors.values()) {
            pref.put(sensor.toString() , FALSE);
        }
        return pref;
    }

    /**Login user to the DB using email and password**/
    public static void loginUser(UserObj currentUserObj) {
        DBInstance dbInstance = DBInstance.getInstance();/*singleton  instance*/

        Credentials inputCredentials = Credentials.emailPassword(currentUserObj.getEmail() , currentUserObj.getPassword());
        dbInstance.getAppInstance().loginAsync(inputCredentials, new App.Callback<User>() {
            @Override
            public void onResult(App.Result<User> result) {
                if (result.isSuccess()) {
                    Log.i("loginUser method", "Successfully login user.");
                    Toast.makeText(getApplicationContext(),
                            "Successfully login", Toast.LENGTH_SHORT).show();

                    /*current logged Realm user*/
                    User currentUserRealm =  dbInstance.getAppInstance().currentUser();


                    if(Get_User_Data(currentUserObj , currentUserRealm) != null)/*if it's a new user have to write a new pref HashMap*/
                    {

                    }
                    write_user_preference_to_db(currentUserObj ,currentUserRealm, createValue());
                } else {
                    Log.e("loginUser method", "Failed to login user: " + result.getError().getErrorMessage());
                    Toast.makeText(getApplicationContext(),
                            "Please try again: "+result.getError().getErrorMessage(), Toast.LENGTH_SHORT).show();
                }
                return;
            }
        });
    }


    /** Registered new user to the DB using email and password**/
    private static void registerNewUser(UserObj user) {
        DBInstance dbInstance = DBInstance.getInstance();/*singleton  instance*/
        dbInstance.getAppInstance().getEmailPassword().registerUserAsync(user.getEmail(), user.getPassword(), result -> {
            if (result.isSuccess()) {
                Log.i("registerNewUser method", "Successfully registered user.");
                Toast.makeText(getApplicationContext(),
                        "Successfully registered", Toast.LENGTH_SHORT).show();
            } else {
                Log.e("registerNewUser method", "Failed to register user: " + result.getError().getErrorMessage());
                Toast.makeText(getApplicationContext(),
                        "Please try again: "+result.getError().getErrorMessage(), Toast.LENGTH_SHORT).show();
            }
            return;
        });
    }

    //end region
}
















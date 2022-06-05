package com.ArielUniversity.finalproject.AccessDB;

import android.app.Application;
import io.realm.Realm;

/**
 * This Application subClass will run before the creation of the first activity of the app
 * because the connection to the DB need to by initialized only once.
 */
public class DBConnect extends Application {

    @Override
    public void  onCreate() {
        super.onCreate();
        Realm.init(this);
        //        app.loginAsync(credentials_temp, result -> {
//            if (result.isSuccess()) {
//                Log.v("QUICKSTART", "Successfully authenticated anonymously.");
////                User user = app.currentUser();
////                mongoClient = user.getMongoClient("mongodb-atlas");
////                users_pref_DB = mongoClient.getDatabase("User_Feature_Pref");
////                sensors_data_DB = mongoClient.getDatabase("Sensors_data");
////                MongoCollection<Document> mongoCollection = users_pref_DB.getCollection("users_pref_DB");
////                Map map = new HashMap();
////                map.put("id","1");
////                mongoCollection.insertOne((Document) map);
//
//                // interact with realm using your user object here
//            } else {
//                Log.e("QUICKSTART", "Failed to log in. Error: " + result.getError());
//            }
//        });
    }
}

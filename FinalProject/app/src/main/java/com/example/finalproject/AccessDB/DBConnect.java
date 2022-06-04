package com.example.finalproject.AccessDB;

import android.app.Application;

import android.util.Log;

import org.bson.Document;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import io.realm.Realm;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.Credentials;
import io.realm.mongodb.User;
import io.realm.mongodb.mongo.MongoClient;
import io.realm.mongodb.mongo.MongoCollection;
import io.realm.mongodb.mongo.MongoDatabase;
import io.realm.mongodb.sync.SyncConfiguration;

/**
 * This Application subClass will run before the creation of the first activity op the app
 * because the connection to the DB need to by initialized only once.
 */
public class DBConnect extends Application {

    private MongoClient mongoClient;
    private MongoDatabase  users_pref_DB;
    private MongoDatabase sensors_data_DB;


    @Override
    public void  onCreate() {
        super.onCreate();
        Realm.init(this);

        String appID = "smartnotebook-nohyl";
        App app = new App(new AppConfiguration.Builder(appID)
                .build());

        Credentials credentials = Credentials.emailPassword("DanielEppler51@gmail.com","De040894@");

//        app.loginAsync(credentials, result -> {
//            if (result.isSuccess()) {
//                Log.v("QUICKSTART", "Successfully authenticated anonymously.");
//                User user = app.currentUser();
//                mongoClient = user.getMongoClient("mongodb-atlas");
//                users_pref_DB = mongoClient.getDatabase("User_Feature_Pref");
//                sensors_data_DB = mongoClient.getDatabase("Sensors_data");
//                MongoCollection<Document> mongoCollection = users_pref_DB.getCollection("users_pref_DB");
//                Map map = new HashMap();
//                map.put("id","1");
//                mongoCollection.insertOne((Document) map);
//
//                // interact with realm using your user object here
//            } else {
//                Log.e("QUICKSTART", "Failed to log in. Error: " + result.getError());
//            }
//        });
    }
}

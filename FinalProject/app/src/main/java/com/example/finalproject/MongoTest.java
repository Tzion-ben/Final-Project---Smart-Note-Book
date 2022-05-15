package com.example.finalproject;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;

public class MongoTest {

    RealmConfiguration config = new RealmConfiguration.Builder()
            .allowQueriesOnUiThread(true)
            .allowWritesOnUiThread(true)
            .build();
    Realm realm = Realm.getInstance(config);
    RealmQuery<Frog> frogsQuery = realm.where(Frog.class);

}

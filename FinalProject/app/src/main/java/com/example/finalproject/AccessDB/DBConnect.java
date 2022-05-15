package com.example.finalproject.AccessDB;

import android.app.Application;

import io.realm.Realm;

/**
 * This Application subClass will run before the creation of the first activity op the app
 * because the connection to the DB need to by initialized only once.
 */
public class ConnectDB extends Application {

    @Override
    public void  onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}

package com.ArielUniversity.finalproject.AccessDB;

import android.app.Application;
import io.realm.Realm;

/**
 * This Application subClass will run before the creation of the first activity of the app
 * because the connection to the DB need to by initialize  d only once.
 */
public class DBConnect extends Application {

    @Override
    public void  onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}

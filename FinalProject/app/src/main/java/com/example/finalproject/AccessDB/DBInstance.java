package com.example.finalproject.AccessDB;
/**
 * This class will create a Singleton instance of Realm DB Instance
 */

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DBInstance {
    /**Static variable reference of a single instance of DBInstance*/
    private static DBInstance _DBInstance = null;

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
    private DBInstance()
    {
        this._config = new RealmConfiguration.Builder()
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .build();
        this._realmInstance = Realm.getInstance(_config);
    }

    /*Static method*/
    /*Static method to create instance of Singleton class*/
    public static DBInstance getInstance()
    {
        if (_DBInstance == null)
            _DBInstance = new DBInstance();

        return _DBInstance;
    }

    /*an instance of realm */
    public Realm getRealmInstance(){
        return this._realmInstance;
    }
}

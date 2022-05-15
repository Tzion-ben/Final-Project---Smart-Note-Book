package com.example.finalproject.AccessDB;
/**
 * This class will create a Singleton instance of Realm CRUD instance
 */

import io.realm.Realm;
import io.realm.RealmConfiguration;

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
    private DB_CRUD()
    {
        this._config = new RealmConfiguration.Builder()
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .build();
        this._realmInstance = Realm.getInstance(_config);
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

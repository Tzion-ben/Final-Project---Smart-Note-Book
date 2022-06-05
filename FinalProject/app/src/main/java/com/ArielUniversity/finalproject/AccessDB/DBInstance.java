package com.ArielUniversity.finalproject.AccessDB;
/**
 * This class will create a Singleton instance of Realm DB Instance
 */

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;

public class DBInstance {
    /**Static variable reference of a single instance of DBInstance*/
    private static DBInstance _DBInstance = null;

    /**
     * Declaring a variable of type Synchronous Reads and Writes on the UI Thread
     * with realm
     */
    private RealmConfiguration _config        =                 null;
    private Realm              _realmInstance =                 null;
    private App                _appInstance   =                 null;
    private final String       APP_ID         = "smartnotebook-nohyl";

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

        /**Will create an instance of the Realm Application in the Android Studio
          *which is linked to the online Realem for ourSmartNoteBook Application */
        this._appInstance = new App(new AppConfiguration.Builder(APP_ID)
                .build());
    }

    ///////////////******************************************************************///////////////
    //public static methods region
    /**Static method
      *Static method to create instance of Singleton class*/
    public static DBInstance getInstance()
    {
        if (_DBInstance == null)
            _DBInstance = new DBInstance();

        return _DBInstance;
    }
    //end region

    ///////////////******************************************************************///////////////
    //public non-static methods region
    /*an instance of realm */
    public Realm getRealmInstance(){
        return this._realmInstance;
    }
    public App getAppInstance()     {return this._appInstance;    }
    //end region
}

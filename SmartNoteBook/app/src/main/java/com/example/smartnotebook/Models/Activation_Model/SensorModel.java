package com.example.smartnotebook.Models.Activation_Model;

import java.util.HashMap;
import java.util.Map;

public class SensorModel {

    /*
        * Hashmap will contain the sensor data. The key will be the sensor id - value will be the real
        * sensor data
    */

    private Map<String,Integer> sensors_data_map = new HashMap<>();

    /*
    * Listener function that will listen to the cloud for data and will put the data into the variable
    * The function will output the variable <sensors_data_map> with the sensors data.
    * After invoking the data from the sensors, we searching for the sensor id in the enum class and get sensor number
    * After we know which sensors is this we send the name/enum/id to the DB and find the relations of the sensor
    * the DB model will returns a array/list of the relations of the sensor. We loop through the container
    * and activate every function according to the relation.
    */



    /*
        There will be list of features functions according to each feature. We will try to make these
        as generic as we can
     */





}

package com.ArielUniversity.finalproject.Threads;

import com.ArielUniversity.finalproject.Models.Activation_Model.SensorModel;

import java.io.IOException;

public class TempMonitoringThread extends Thread{

    long MonitoringInterval;
    SensorModel sensorModel;
    long lastTimeCheck = System.currentTimeMillis();

    public TempMonitoringThread(long MonitoringInterval, SensorModel sensorModel)
    {
        this.MonitoringInterval = MonitoringInterval;
        this.sensorModel = sensorModel;
    }

    public void run()
    {
        if((System.currentTimeMillis() - lastTimeCheck) > this.MonitoringInterval)
        {
            try {
                this.sensorModel.MonitorTemperature();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

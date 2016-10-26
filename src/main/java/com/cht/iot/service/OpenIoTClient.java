package com.cht.iot.service;

import java.util.List;

import com.cht.iot.persistence.entity.data.HeartBeat;
import com.cht.iot.persistence.entity.data.Rawdata;
import com.cht.iot.persistence.entity.data.Session;

public interface OpenIoTClient {
	// ======
	   
    void setHost(String host);
 
    void setHttpPort(int port);
   
    void setHttpsPort(int port);
   
    void setMqttPort(int port);
   
    /**
    * This is a account key or project key
    *
     * @param apiKey
    */
    void setProjectKey(String projectKey);
   
    /**
    * UDP/10400 to listen
    *
     * @param port
    */
    void setAnnouncementPort(int port);
   
    /**
    * TCP/10400 to connect
    *
     * @param port
    */
    void setControllerPort(int port);
   
    /**
    * To IoT platform & controller.
    *
     * @param timeout
    */
    void setTimeout(int timeout);
   
    /**
    * This is an interval of 'Ping' command to controller.
    *
     * @param timeout
    */
    void setKeepAliveInterval(long timeout);
   
    // ======
   
    void start();
   
    void stop();
   
    // ======
   
    /**
    * Get controllers in LAN.
    *
     * @return Session includes vendor, model, series, name, cipher & extra for user to assign device key.
    *
     * (cipher & extra will be retrieved when controller's connection is ready)
    *
     *
     */
    List<Session> getSessions();
   
    /**
    * Ask OpenIoTClient to establish the connection to controller in background.
    *
     * After connecting to controller, the background thread will send the 'Ping' to keep the tcp connection.
    *
     * @param session
    * @param apiKey     device key
    * @param deviceId       keep the deviceId/sessionId -> Session, you'll know how to send the rawdata later.
    * @param sensorIds
    */
    void link(Session session, String apiKey, String deviceId, String[] sensorIds);
   
    // ======
   
    /*
    * By IoT platform only.
    *
     * saveDevice(), modifyDevice(), getDevice(), getDevices(), deleteDevice()
    * saveSensor(), modifySensor(), getSensor(), getSensors(), deleteSensor()
    *
     */
   
    /**
    * Save the rawdata to IoT platform and local controller.
    *
     * Based on deviceId/sessionId -> Session which defined by link(), you will select the ControllerClient to send the 'write' command.
    *
     * @param deviceId
    * @param sensorId
    * @param value
    */
    void saveRawdata(String deviceId, String sensorId, String[] value);
   
    /**
    * Read the rawdata from local controller or IoT platform.
    *
     * Based on deviceId/sessionId -> Session which defined by link(), you will select the ControllerClient to send the 'read' command.
    *
     * @param deviceId
    * @param sensor
    * @return
    */
    Rawdata getRawdata(String deviceId, String sensorId);
   
   
    /*
    * By IoT platform only.
    *
     * getRawdatas(), deleteRawdata()
    * saveSnapshot(), getSnapshotMeta(), getSnapshotMetas(), getSnapshotBody(), deleteSnapshot()
    *
     */
   
    /*
    * By IoT platform only.
     *
     * saveHeartbeat(), getHeartbeat()
    *
     */
   
   
    /**
    * Subscribe the rawdata changed.
    *
     * @param deviceId
    * @param sensorId
    */
    void subscribe(String deviceId, String sensorId);
   
    /**
    * By default, OpenIoTClient will connect to MQTT broker to listen the rawdata changed message.
    *
     * @author rickwang
    *
    */
    interface Callback {
       void onRawdata(Rawdata rawdata);
       void onHeartBeat(HeartBeat heartbeat);
    }
}

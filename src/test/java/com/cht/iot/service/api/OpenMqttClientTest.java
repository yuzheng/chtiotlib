package com.cht.iot.service.api;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;

import com.cht.iot.persistence.entity.data.Ack;
import com.cht.iot.persistence.entity.data.Command;
import com.cht.iot.persistence.entity.data.HeartBeat;
import com.cht.iot.persistence.entity.data.Rawdata;
import com.cht.iot.service.api.OpenMqttClient.Listener;

public class OpenMqttClientTest {
	String host = "iot.cht.com.tw";
	int port = 1883;//8883;//1883;
	String apiKey = "PK1G27KG0PUFFTGBX0";		// CHANGE TO YOUR PROJECT API KEY
	String serialId = "001002003004005";	// CHANGE TO YOUR EQUIPMENT SERIAL NUMBER
	
	String deviceId = "388622157";					// CHANGE TO YOUR DEVICE ID
	String sensorId = "button";				// CHANGE TO YOUR SENSOR ID
	
	@Test
	public void testMulti()throws Exception {
		OpenMqttClient mqc1 = new OpenMqttClient(host, 1883, "DKPWWEMFPGX7C2571M", false);
		OpenMqttClient mqc2 = new OpenMqttClient(host, 1883, "DKAEZE792XM93U9HWM", false);
		
		mqc1.subscribe("276664437", "aaa");
		mqc2.subscribe("281494258", "light");
		
		mqc1.subscribeHeartbeat("276664437");
		mqc2.subscribeHeartbeat("281494258");
		
		mqc1.setListener(new Listener() {
			@Override
			public void onRawdata(String topic, Rawdata rawdata) {
				System.out.printf("Rawdata - deviceId: %s, id: %s, time: %s, value: %s\n", rawdata.getDeviceId(), rawdata.getId(), rawdata.getTime(), rawdata.getValue()[0]);				
			}
			
			@Override
			public void onCommand(String topic, Command command) {
				System.out.printf("Command - deviceId: %s, id: %s, time: %s, value: %s\n", command.getDeviceId(), command.getId(), command.getTime(), command.getCmd());				
			}
			
			@Override
			public void onAck(String topic, Ack ack) {
				System.out.printf("Ack - deviceId: %s, id: %s, time: %s, value: %s\n", ack.getDeviceId(), ack.getId(), ack.getTime(), ack.getAck());				
			}
			
			@Override
			public void onHeartBeat(String topic, HeartBeat heartbeat) {
				System.out.printf("HeartBeat - deviceId: %s, pulse: %s, from: %s, time: %s, type: %s\n", heartbeat.getDeviceId(), heartbeat.getPulse(), heartbeat.getFrom(), heartbeat.getTime(), heartbeat.getType());				
			}
			
			@Override
			public void onReconfigure(String topic, String apiKey) {
				System.out.printf("Reconfigure - topic: %s, apiKey: %s\n", topic, apiKey);
			}
			
			@Override
			public void onSetDeviceId(String topic, String apiKey, String deviceId) {
				System.out.printf("SetDeviceId - topic: %s, apiKey: %s, deviceId: %s\n", topic, apiKey, deviceId);
			}
		});
		
		mqc2.setListener(new Listener() {
			@Override
			public void onRawdata(String topic, Rawdata rawdata) {
				System.out.printf("Rawdata - deviceId: %s, id: %s, time: %s, value: %s\n", rawdata.getDeviceId(), rawdata.getId(), rawdata.getTime(), rawdata.getValue()[0]);				
			}
			
			@Override
			public void onCommand(String topic, Command command) {
				System.out.printf("Command - deviceId: %s, id: %s, time: %s, value: %s\n", command.getDeviceId(), command.getId(), command.getTime(), command.getCmd());				
			}
			
			@Override
			public void onAck(String topic, Ack ack) {
				System.out.printf("Ack - deviceId: %s, id: %s, time: %s, value: %s\n", ack.getDeviceId(), ack.getId(), ack.getTime(), ack.getAck());				
			}
			
			@Override
			public void onHeartBeat(String topic, HeartBeat heartbeat) {
				System.out.printf("HeartBeat - deviceId: %s, pulse: %s, from: %s, time: %s, type: %s\n", heartbeat.getDeviceId(), heartbeat.getPulse(), heartbeat.getFrom(), heartbeat.getTime(), heartbeat.getType());				
			}
			
			@Override
			public void onReconfigure(String topic, String apiKey) {
				System.out.printf("Reconfigure - topic: %s, apiKey: %s\n", topic, apiKey);
			}
			
			@Override
			public void onSetDeviceId(String topic, String apiKey, String deviceId) {
				System.out.printf("SetDeviceId - topic: %s, apiKey: %s, deviceId: %s\n", topic, apiKey, deviceId);
			}
		});
		mqc2.start(); // wait for incoming message
		mqc1.start(); // wait for incoming message
		
		
		Thread.sleep(2000L);
		mqc1.heartbeat("276664437", 10000);
		mqc2.heartbeat("281494258", 10000);
		for (;;) {			
			Thread.sleep(2000L);
			
			String[] value = new String[] { RandomStringUtils.randomNumeric(5) };			
			mqc1.save("276664437", "aaa", value); // change the rawdata
			String[] value3 = new String[] { RandomStringUtils.randomNumeric(5) };			
			mqc2.save("281494258", "light", value3); // change the rawdata
		}
		
	}
	
	@Test
	public void test() throws Exception {
		//OpenMqttClient mqc = new OpenMqttClient(host, port, apiKey);
		OpenMqttClient mqc = new OpenMqttClient(host, 1883, apiKey, false);
		
		//mqc.register(serialId); // '/v1/registry/001002003004005'
		mqc.subscribe(deviceId, sensorId); // '/v1/device/25/sensor/sensor-0/rawdata'
		mqc.subscribeCommand(deviceId, sensorId);
		mqc.subscribeAck(deviceId, sensorId);
		mqc.subscribeHeartbeat(deviceId);
		
		mqc.setListener(new Listener() {
			@Override
			public void onRawdata(String topic, Rawdata rawdata) {
				System.out.printf("Rawdata - deviceId: %s, id: %s, time: %s, value: %s\n", rawdata.getDeviceId(), rawdata.getId(), rawdata.getTime(), rawdata.getValue()[0]);				
			}
			
			@Override
			public void onCommand(String topic, Command command) {
				System.out.printf("Command - deviceId: %s, id: %s, time: %s, value: %s\n", command.getDeviceId(), command.getId(), command.getTime(), command.getCmd());				
			}
			
			@Override
			public void onAck(String topic, Ack ack) {
				System.out.printf("Ack - deviceId: %s, id: %s, time: %s, value: %s\n", ack.getDeviceId(), ack.getId(), ack.getTime(), ack.getAck());				
			}
			
			@Override
			public void onHeartBeat(String topic, HeartBeat heartbeat) {
				System.out.printf("HeartBeat - deviceId: %s, pulse: %s, from: %s, time: %s, type: %s\n", heartbeat.getDeviceId(), heartbeat.getPulse(), heartbeat.getFrom(), heartbeat.getTime(), heartbeat.getType());				
			}
			
			@Override
			public void onReconfigure(String topic, String apiKey) {
				System.out.printf("Reconfigure - topic: %s, apiKey: %s\n", topic, apiKey);
			}
			
			@Override
			public void onSetDeviceId(String topic, String apiKey, String deviceId) {
				System.out.printf("SetDeviceId - topic: %s, apiKey: %s, deviceId: %s\n", topic, apiKey, deviceId);
			}
		});
		
		mqc.start(); // wait for incoming message
		Thread.sleep(2000L);
		mqc.heartbeat(deviceId, 10000);
		for (;;) {			
			Thread.sleep(2000L);
			
			String[] value = new String[] { RandomStringUtils.randomNumeric(5) };			
			mqc.save(deviceId, sensorId, value); // change the rawdata
		}
	}
}
package com.cht.iot.persistence.entity.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "projectId" , "save"})
public class Ack extends Material {
	private static final long serialVersionUID = 1L;
	
	protected String id; // SENSOR NAME (not database id)
//	protected Long projectId; // assign by internal service
	protected String deviceId; // assign by internal service
	protected String time;
	
	protected Float lat;
	protected Float lon;
	protected String ack;

	public Ack() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeviceId() {
		return deviceId;
	}
	
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Float getLon() {
		return lon;
	}

	public void setLon(Float lon) {
		this.lon = lon;
	}

	public String getAck() {
		return ack;
	}

	public void setAck(String ack) {
		this.ack = ack;
	}
}

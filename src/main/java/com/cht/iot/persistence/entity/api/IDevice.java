package com.cht.iot.persistence.entity.api;

import java.util.Map;

public class IDevice {	
	public static final String NO_ID = "0";
	
	String id;
	String name;
	String desc;
	String type;
	String uri;
	Float lat;
	Float lon;
	String key;
	IAttribute[] attributes;
	Map<String, String> type_extras;
	
	public IDevice() {		
	}

	/**
	 * Device ID. (decimal)
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Device name.
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * [optional] Device description.
	 * 
	 * @return
	 */
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * Device type. You can use 'general' as default type.
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * [optional] Device URI.
	 * 
	 * @return
	 */
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * [optional] Device latitude.
	 * 
	 * @return
	 */
	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	/**
	 * [optional] Device longitude.
	 * 
	 * @return
	 */
	public Float getLon() {
		return lon;
	}

	public void setLon(Float lon) {
		this.lon = lon;
	}
	
	/**
	 * [optional] Device key
	 * 
	 * @return
	 */
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * [optional] Extra attributes. Key-Value style.
	 * 
	 * @return
	 */
	public IAttribute[] getAttributes() {
		return attributes;
	}

	public void setAttributes(IAttribute[] attributes) {
		this.attributes = attributes;
	}

	public Map<String, String> getType_extras() {
		return type_extras;
	}

	public void setType_extras(Map<String, String> type_extras) {
		this.type_extras = type_extras;
	}	
}

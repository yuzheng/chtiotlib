package com.cht.iot.persistence.entity.api;

public class ITypeExtra {
	protected String key;
	protected String value;
	
	public ITypeExtra() {
	}
	
	public ITypeExtra(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}

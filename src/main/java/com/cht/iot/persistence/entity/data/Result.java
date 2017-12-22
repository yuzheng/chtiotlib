package com.cht.iot.persistence.entity.data;

public class Result {
	private String topic;
	private boolean result = true;	// 預設 result 為 true，若 server 端回傳錯誤訊息時，result 會設為 false
	private String message;
	
	private Object data;
	
	public Result() {
		// TODO Auto-generated constructor stub
	}
	
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}

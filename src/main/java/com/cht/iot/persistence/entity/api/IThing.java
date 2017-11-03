package com.cht.iot.persistence.entity.api;

public class IThing {
	/*
	 * YuCheng
	 * 用於回傳產品物件資訊(綁定設備, 所屬產品)
	 */

	public static final String NO_ID = "";
	
	protected String id; // thing id	
	protected String sn;
	protected String digest;
	protected String deviceId;
	protected String productId;
	protected String productCode;
	
	public IThing(){		
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
}

package com.cht.iot.util;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;


public class JsonUtils {

	static final ObjectMapper jackson = new ObjectMapper();
	static {
		jackson.setSerializationInclusion(Inclusion.NON_NULL);
	}
	
	public static String toJson(Object obj) {
		try {
			jackson.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return jackson.writeValueAsString(obj);
			
		} catch (IOException e) {
			throw new OperationException(e.getMessage(), e);
		}
	}
	
	public static <T> T fromJson(InputStream is, Class<T> clazz) {
		try {
			jackson.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return jackson.readValue(is, clazz);
			
		} catch (IOException e) {
			throw new OperationException(e.getMessage(), e);
		}
	}
	
	public static <T> T fromJson(Reader r, Class<T> clazz) {
		try {
			jackson.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return jackson.readValue(r, clazz);
			
		} catch (IOException e) {
			throw new OperationException(e.getMessage(), e);
		}
	}
	
	public static <T> T fromJson(String s, Class<T> clazz) {
		try {
			jackson.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return jackson.readValue(s, clazz);
			
		} catch (IOException e) {
			throw new OperationException(e.getMessage(), e);
		}
	}
}

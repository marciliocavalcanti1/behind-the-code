package br.com.softblue.bluewitter.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	public static <T> T fromJson(String json, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		return new ObjectMapper().readValue(json, clazz);
	}
}

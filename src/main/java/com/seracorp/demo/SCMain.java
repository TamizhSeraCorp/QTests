package com.seracorp.demo;

import com.google.gson.Gson;
import com.seracorp.demo.model.LoginJson;

public class SCMain {
	private static final String SEMICOLON = ";";

	public static void main(String[] args) {
		LoginJson json = new Gson().fromJson("{\"apikey\": \"4D0C09CAF0290409\"}", LoginJson.class);
		System.out.println(null != json);
		System.out.println(json.getApikey());
	}
}

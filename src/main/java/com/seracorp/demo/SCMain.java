package com.seracorp.demo;

import com.seracorp.demo.model.QuestionSet;
import com.seracorp.demo.util.StringUtils;

public class SCMain {
	private static final String SEMICOLON = ";";

	public static void main(String[] args) {
		String a = "a,b;c,d;e,f;g,h;";
		StringUtils.splitAndList(a, SEMICOLON).forEach(QuestionSet::new);
	}
}

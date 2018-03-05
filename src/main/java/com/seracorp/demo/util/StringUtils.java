package com.seracorp.demo.util;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringUtils {
	public static List<String> splitAndList(String a, String delimiter) {
		List<String> collect = Pattern.compile(delimiter).splitAsStream(a).map(String::trim).collect(Collectors.toList());
		collect.forEach(System.out::println);
		return collect;
	}
}

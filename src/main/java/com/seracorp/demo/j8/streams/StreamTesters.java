package com.seracorp.demo.j8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTesters {
public static void main(String[] args) {
	List<String> list = new ArrayList();
	list.add("1");
	list.add("a");
	list.add("");
	list.add(null);
	list.add("1");
	list.add(null);
	
	List<String> collect = list.stream().filter(w -> w != null).collect(Collectors.toList());
	collect.stream().forEach(System.out::println);
	
}
}

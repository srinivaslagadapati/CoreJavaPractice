package com.lsr.basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMapAndFlatMap {
	
	public static void main(String[] args) {

	
	List<User> users = Stream.of(new User(1,"Sri","2029872343",Arrays.asList("sri@gmail.com")),
									new User(2,"ram","2029872342",Arrays.asList("ram@gmail.com")))
						.collect(Collectors.toList());
	
	List<String> name = users.stream().map(User::getName).collect(Collectors.toList());
	
	System.out.println(name);
	

List<List<String>> emails = users.stream().map(User::getEmail).collect(Collectors.toList());

System.out.println(emails); //[[sri@gmail.com], [ram@gmail.com]]

List<String> emailList = users.stream().flatMap(u->u.getEmail().stream()).collect(Collectors.toList());

System.out.println(emailList); //[sri@gmail.com, ram@gmail.com]



	}
}

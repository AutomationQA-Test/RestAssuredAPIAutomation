package com.utility;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	
	public static String getName(){
		String name = RandomStringUtils.randomAlphanumeric(5);
		System.out.println("Name : " +name);
		return name;
	}
	
	
	public static String getJob(){
		String job = RandomStringUtils.randomAlphanumeric(5);
		System.out.println("Name : " +job);
		return job;
	}

}

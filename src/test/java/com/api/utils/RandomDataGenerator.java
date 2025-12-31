package com.api.utils;

import com.github.javafaker.Faker;

public class RandomDataGenerator {

	public static Faker faker = new Faker();
	
	public static String randomUserName() {
		return faker.name().username();
	}
	
	
}

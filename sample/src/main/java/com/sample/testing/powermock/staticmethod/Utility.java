package com.sample.testing.powermock.staticmethod;

public class Utility {
	
	public static String staticMethod(String message) {
		return Utility.changeToLowerCase(message);
	}
	
	public static String changeToLowerCase(String message) {
		message = message.toLowerCase();
		return Utility.changeToUpperCase(message);
	}
	
	private static String changeToUpperCase(String message) {
		message = message.toUpperCase();
		return Utility.addBuilder(message);
		
	}
	
	private static String addBuilder(String message) {
		Builder builder = new Builder();
		
		return builder.addBuilder(message);
	}
	
	

}

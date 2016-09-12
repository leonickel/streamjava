package com.leonickel.util;

import java.util.UUID;

public class Utils {

	/**
	 * Generates a random string value based on UUID mechanism 
	 * @return
	 */
	public static String generateRandomStream() {
		return UUID.randomUUID().toString(); 
	}
}

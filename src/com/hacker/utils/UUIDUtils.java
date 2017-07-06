package com.hacker.utils;

import java.util.UUID;

public class UUIDUtils {

	public static String getUUID() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString().replace("-", "");
	}
	
}


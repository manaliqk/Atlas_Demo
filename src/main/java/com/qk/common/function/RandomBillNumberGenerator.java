package com.qk.common.function;

import java.util.UUID;

public class RandomBillNumberGenerator {

	String number="";
	public String RandomBillNumber() {
		String random5Digts = UUID.randomUUID().toString().substring(0, 5);
		String randomNumber="QK_"+random5Digts;
		StringBuilder sb = new StringBuilder(randomNumber);
		for (int index = 0; index < sb.length(); index++) {
			char c = sb.charAt(index);
			if (Character.isLowerCase(c)) {
				sb.setCharAt(index, Character.toUpperCase(c));
			}
		}
		System.out.println("Bill number is " + sb.toString());
		String number = sb.toString();
		System.out.println(number);
		return number;	
}
}
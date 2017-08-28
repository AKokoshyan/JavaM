package com.strings;

import java.util.Scanner;

public class UrlValidation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();

		String option = getOption(text);
		System.out.println(option);
	}

	static String getOption(String text) {
		String firstTarget = "?target=self";
		String secondTarget = "?target=internal";
		String thirdTarget = "?target=external";
		int tempStart = 0;
		int tempEnd = 0;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == '?') {
				tempStart = i;
			}
			if (text.charAt(i) == '&') {
				tempEnd = i;
			}
		}
		String subString = text.substring(tempStart, tempEnd);
		if (subString.equals(firstTarget) || subString.equals(secondTarget) || subString.equals(thirdTarget)) {
			if (subString.equals(firstTarget)) {
				return "self";
			}
			if (subString.equals(secondTarget)) {
				return "internal";
			}
			if (subString.equals(thirdTarget)) {
				return "external";
			}
		}

		return "losho";
	}
}
//www.musala.com?target=self&

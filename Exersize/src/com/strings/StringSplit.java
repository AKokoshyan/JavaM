package com.strings;

import java.util.Scanner;

public class StringSplit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] result = getWords(input);
		System.out.println(result.toString());

	}

	static String[] getWords(String string) {

		return string.toLowerCase().split(" ");
	}
}

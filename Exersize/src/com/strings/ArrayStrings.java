package com.strings;

public class ArrayStrings {
	public static void main(String[] args) {
		String[] arrays = { " auieo", "asdkal", "aaaaaaa" };
		boolean isNotVowels = true;

		for (int i = 0; i < arrays.length; i++) {
			String text = arrays[i].trim();
			for (int j = 0; j < text.length(); j++) {
				if (text.toLowerCase().charAt(j) != 'a' && text.charAt(j) != 'e' && text.charAt(j) != 'i' && text.charAt(j) != 'o'
						&& text.charAt(j) != 'u') {
					isNotVowels = false;
				}
			}
			if (isNotVowels) {
				System.out.println(text.trim());
			}
			isNotVowels = true;
		}

	}
}

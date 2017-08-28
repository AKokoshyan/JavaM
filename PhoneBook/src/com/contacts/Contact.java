package com.contacts;

import java.util.Random;

public class Contact {

	// Set default values for name unknown and for number ***********
	private final int RANDOM_NUMBER = new Random().nextInt(200) + 1;
	private String name;
	private String number;
	private Integer durationOutgoing;

	public Contact(String name, String number) throws NameIsNullException, NumberIsNullException {
		setName(name);
		setNumber(number);
		this.durationOutgoing = RANDOM_NUMBER;
	}

	private void setName(String name) throws NameIsNullException {
		if (name != null) {
			this.name = name;
		} else {
			throw new NameIsNullException();
		}
	}

	private void setNumber(String number) throws NumberIsNullException {
		if (number == null) {
			throw new NumberIsNullException();
		}

		String correctNumber = correctNumber(number);
		this.number = correctNumber;
	}

	private String correctNumber(String number) {
		String correctNumber;
		if (number != null) {
			if (validateNumber(number)) {
				if (number.startsWith("00")) {
					correctNumber = "+" + number.substring(2);
				} else if (number.startsWith("0")) {
					correctNumber = "+359" + number.substring(1);
				} else {
					correctNumber = number;
				}
			} else {
				correctNumber = "**********";
			}
		} else {
			correctNumber = "**********";
		}

		return correctNumber;
	}

	public String getName() {
		return this.name;
	}

	private boolean validateNumber(String number) {
		boolean isValidNumber = false;
		if (number.length() == 10 || number.length() == 13 || number.length() == 14) {
			if (number.length() == 13) {
				if (number.charAt(0) == '+' && number.charAt(1) == '3' && number.charAt(2) == '5'
						&& number.charAt(3) == '9' && number.charAt(4) == '8'
						&& (number.charAt(5) >= '7' || number.charAt(5) <= '9')
						&& (number.charAt(6) >= '2' || number.charAt(6) <= '9')) {
					isValidNumber = true;
				}
				for (int i = 7; i < number.length(); i++) {
					if (number.charAt(i) < '0' || number.charAt(i) > '9') {
						isValidNumber = false;
						break;
					}
				}
			}
			if (number.length() == 10) {
				if (number.charAt(0) == '0' && number.charAt(1) == '8'
						&& (number.charAt(2) >= '7' || number.charAt(2) <= '9')
						&& (number.charAt(3) >= '2' || number.charAt(3) <= '9')) {
					isValidNumber = true;
				}
				for (int i = 4; i < number.length(); i++) {
					if (number.charAt(i) < '0' || number.charAt(i) > '9') {
						isValidNumber = false;
						break;
					}
				}
			}
			if (number.length() == 14) {
				if (number.charAt(0) == '0' && number.charAt(1) == '0' && number.charAt(2) == '3'
						&& number.charAt(3) == '5' && number.charAt(4) == '9' && number.charAt(5) == '8'
						&& (number.charAt(6) >= '7' || number.charAt(6) <= '9')
						&& (number.charAt(7) >= '2' || number.charAt(7) <= '9')) {
					isValidNumber = true;
				}
				for (int i = 8; i < number.length(); i++) {
					if (number.charAt(i) < '0' || number.charAt(i) > '9') {
						isValidNumber = false;
						break;
					}
				}
			}
		}
		return isValidNumber;
	}

	@Override
	public String toString() {
		return name + " " + number + " " + durationOutgoing;
	}

	class NumberIsNullException extends Exception {

	}

	class NameIsNullException extends Exception {

	}
}

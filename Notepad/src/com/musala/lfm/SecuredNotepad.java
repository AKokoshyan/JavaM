package com.musala.lfm;

import java.util.Scanner;

public class SecuredNotepad extends Notepad {
	private Scanner sc = new Scanner(System.in);
	private String password;
	private boolean accessDenied = false;
	private long start;

	// Constructors
	public SecuredNotepad(String name, int size, String password) {
		super(name, size);
		this.start = System.currentTimeMillis();
		setPassword(password);

	}

	// Getters and setters
	private void setPassword(String password) {
		if (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!^&+=])(?=\\S+$).{8,}$")) {
			this.password = password;
			return;
		}
		String newAttepmtPass = sc.nextLine();
		setPassword(newAttepmtPass);
	}

	// Public methods

	@Override
	void printPage(int num) {
		String checkPassword = sc.nextLine();
		if (this.password.equals(checkPassword)) {
			super.printPage(num);
		}
	}

	@Override
	public int searchText(String text) {
		checkPassword();
		return super.searchText(text);
	}

	@Override
	public String toString() {
		if (!accessDenied) {

			checkPassword();
			return super.toString();
		}
		return "";
	}

	@Override
	public void addText(int pageNumber) {
		if (!accessDenied) {
			checkPassword();
			super.addText(pageNumber);
		}
	}

	private void checkPassword() {
		String checkPassword;
		long end = System.currentTimeMillis();
		long result = (end - this.start) / 1000;
		if (result > 10) {

			do {
				int triesUntilBlocking = 3;
				int tries = 0;
				checkPassword = sc.nextLine();
				if (!this.password.equals(checkPassword)) {
					triesUntilBlocking -= 1;
					System.out.println("Incorect password! You have " + triesUntilBlocking + " tries remaining!");
					tries++;
				}
				if (tries == 3) {
					this.accessDenied = false;
					return;
				}
			} while (!this.password.equals(checkPassword));
		}

	}

}

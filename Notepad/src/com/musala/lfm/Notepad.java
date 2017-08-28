package com.musala.lfm;

import java.util.Scanner;

public class Notepad implements Searchable {
	private Scanner sc = new Scanner(System.in);
	private int size;
	private Sheet[] pages;
	private String name;

	// Constructors

	public Notepad(String name, int size) {
		setName(name);
		setSize(size);
		setPages(this.size);
	}

	// Setters and getters
	private void setSize(int size) {
		if (size > 0) {
			this.size = size;
		}
	}

	private void setName(String name) {
		if (name != null) {
			this.name = name;
		}
	}

	private void setPages(int size) {
		pages = new Sheet[size];
		for (int i = 0; i < pages.length; i++) {
			pages[i] = new Sheet();
		}
	}

	// Public methods

	void printPage(int num) {
		if (num > 0 && num < pages.length) {
			System.err.println(pages[num].getTopic() + "\n" + pages[num].getText());
		}
	}

	@Override
	public String toString() {
		String notepadToString = "";
		for (int i = 0; i < pages.length; i++) {
			notepadToString += pages[i].getTopic() + "\n" + pages[i].getText()
					+ "\n----------------------------------------------";
		}
		return notepadToString;
	}

	@Override
	public int searchText(String text) {
		for (int i = 0; i < pages.length; i++) {
			if (pages[i].getText().equals(text.toLowerCase().trim())) {
				return i;
			}
		}
		return -1;
	}

	public void addText(int pageNumber) {
		String text = sc.nextLine();
		text = sc.nextLine();
		if (pageNumber > 0 && pageNumber < pages.length) {
			pages[pageNumber].setText(text);
		}
	}
}

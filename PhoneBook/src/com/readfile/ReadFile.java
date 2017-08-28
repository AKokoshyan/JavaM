package com.readfile;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {

	private Scanner reader;
	private File privateFile = new File("E:\\JavaMusala\\WorkingWithFIles\\src\\text.txt");

	public void openFile() {
		try {
			reader = new Scanner(privateFile);
		} catch (Exception e) {
			System.out.println("No such file!");
		}
	}

	public ArrayList<String> readFile() {
		ArrayList<String> contacts = new ArrayList<String>();
		while (reader.hasNext()) {
			contacts.add(reader.nextLine());
		}
		
		return contacts;
	}

	public void closeFile() {
		reader.close();
	}

	public void showPath() {
		System.out.println(privateFile.toPath());
	}
}

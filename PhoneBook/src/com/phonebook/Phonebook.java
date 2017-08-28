package com.phonebook;

import java.util.ArrayList;
import java.util.Comparator;

import com.contacts.Contact;

public class Phonebook {

	private String name;
	private ArrayList<Contact> contactList;

	public Phonebook(String name) {
		setName(name);
		this.contactList = new ArrayList<>();
	}

	private void setName(String name) {
		if (name != null) {
			this.name = name;
		} else {
			this.name = "undefined";
		}

	}

	public void fillContactList(ArrayList<String> contacts) {
		for (int i = 0; i < contacts.size(); i++) {
			String[] separator = contacts.get(i).split("-");
			for (int j = 0; j < separator.length; j++) {
				if (j < separator.length - 1) {
					contactList.add(new Contact(separator[j], separator[j + 1]));
				}
			}
		}
	}

	@Override
	public String toString() {

		contactList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
		String result = "";
		result += this.name + "\n";
		for (int i = 0; i < contactList.size(); i++) {
			result += contactList.get(i).toString() + "\n";
		}
		return result;
	}
}

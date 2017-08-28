import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import com.contacts.Contact;
import com.phonebook.Phonebook;
import com.readfile.ReadFile;

public class Demo {

	private static int a = 1;

	private static Scanner readTextFromFile;
	private static File privateFile = new File("E:\\JavaMusala\\PhoneBook\\src\\com\\contacts\\text.txt");

	public static void main(String[] args) {

		openFile();
		ArrayList<String> contacts = readFile();
		closeFile();
		Phonebook phonebook = new Phonebook("Tonio's phone");
		phonebook.fillContactList(contacts);
		System.out.println(phonebook);
	}

	public static void openFile() {
		try {
			readTextFromFile = new Scanner(privateFile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static ArrayList<String> readFile() {
		ArrayList<String> contacts = new ArrayList<String>();
		while (readTextFromFile.hasNext()) {
			contacts.add(readTextFromFile.nextLine());
		}

		return contacts;
	}

	public static void closeFile() {
		readTextFromFile.close();
	}

}

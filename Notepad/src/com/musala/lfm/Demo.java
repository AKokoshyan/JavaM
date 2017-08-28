package com.musala.lfm;

import java.time.LocalDate;

public class Demo {

	public static void main(String[] args) {
		// SecuredNotepad registyr = new SecuredNotepad("Ocenki", 10,
		// "Ak834282!");
		// registyr.addText(1);
		// System.out.println(registyr);

		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plusDays(1);
		System.out.println(tomorrow);
	}

}

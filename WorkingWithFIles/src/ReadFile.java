import java.io.File;
import java.util.Scanner;

public class ReadFile {

	private Scanner x;
	private File privateFile = new File("E:\\JavaMusala\\WorkingWithFIles\\src\\text.txt");

	public void openFile() {
		try {
			x = new Scanner(privateFile);
		} catch (Exception e) {
			System.out.println("No such file!");
		}
	}

	public String readFile() {
		String a = "";
		while (x.hasNext()) {
			a += x.nextLine();
			a += " ";
		}
		return a;

	}

	public void closeFile() {
		x.close();
	}

	public void showPath() {
		System.out.println(privateFile.toPath());
	}
}

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FilesExercise {

	public static void main(String[] args) {
		ReadFile text = new ReadFile();
		text.openFile();

		String result = text.readFile();
		text.closeFile();
		System.out.println(result);
	}
}

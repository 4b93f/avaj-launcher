package Method;
import java.io.File;
import java.io.FileWriter;

public class FileWriting {
	private static final File file = new File("simulation.txt");
	public static void writeToFile(String content) {
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write(content + System.lineSeparator());
			writer.close();
		} catch (Exception e) {
			System.err.println("Error writing to file: " + e.getMessage());
		}
	}

	public static void alreadyExists() {
		try {
			if (file.exists()) {
				file.delete();
			}
		} catch (Exception e) {
			System.err.println("Error creating file: " + e.getMessage());
		}
	}
}
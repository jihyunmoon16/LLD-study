package logger;

import java.io.FileWriter;

public class FileLogWriter implements LogWriter{
	private String filePath;

	public FileLogWriter(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public void write(String message) {
		try (FileWriter fw = new FileWriter(filePath, true)) {
			fw.write(message + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

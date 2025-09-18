package logger;

import java.util.ArrayList;
import java.util.List;

class CompositeLogWriter implements LogWriter {
	private List<LogWriter> writers = new ArrayList<>();

	public void addWriter(LogWriter writer) {
		writers.add(writer);
	}

	public void write(String message) {
		for (LogWriter w : writers) {
			w.write(message);
		}
	}
}

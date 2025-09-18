package logger;

import java.time.LocalDateTime;

class LogEvent {
	private LocalDateTime timestamp;
	private LogLevel level;
	private String message;

	public LogEvent(String message, LogLevel level) {
		this.timestamp = LocalDateTime.now();
		this.level = level;
		this.message = message;
	}

	public LogLevel getLevel() { return level; }

	public String toJson() {
		return String.format(
			"{\"timestamp\":\"%s\",\"level\":\"%s\",\"message\":\"%s\"}",
			timestamp, level, message.replace("\"", "\\\"")
		);
	}
}

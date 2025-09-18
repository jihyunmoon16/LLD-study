package logger;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// Logger 클래스
public class Logger {
	private static Logger instance;
	private LogLevel logLevel;
	private BlockingQueue<LogEvent> logQueue;
	private Thread workerThread;
	private volatile boolean running = true;
	private EnumMap<LogLevel, CompositeLogWriter> writers;

	private Logger(LogLevel level) {
		this.logLevel = level;
		this.logQueue = new LinkedBlockingQueue<>();
		this.writers = new EnumMap<>(LogLevel.class);

		// 레벨별 CompositeLogWriter 초기화
		for (LogLevel l : LogLevel.values()) {
			writers.put(l, new CompositeLogWriter());
		}

		// 기본 Writer 등록 (파일 + 콘솔)
		writers.get(LogLevel.DEBUG).addWriter(new FileLogWriter("debug.log"));
		writers.get(LogLevel.DEBUG).addWriter(new ConsoleLogWriter());
		writers.get(LogLevel.INFO).addWriter(new FileLogWriter("info.log"));
		writers.get(LogLevel.INFO).addWriter(new ConsoleLogWriter());
		writers.get(LogLevel.WARN).addWriter(new FileLogWriter("warn.log"));
		writers.get(LogLevel.WARN).addWriter(new ConsoleLogWriter());
		writers.get(LogLevel.ERROR).addWriter(new FileLogWriter("error.log"));
		writers.get(LogLevel.ERROR).addWriter(new ConsoleLogWriter());

		// 워커 스레드 시작
		workerThread = new Thread(() -> {
			while (running || !logQueue.isEmpty()) {
				try {
					LogEvent event = logQueue.take();
					writers.get(event.getLevel()).write(event.toJson());
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});
		workerThread.start();
	}

	public static synchronized Logger getInstance() {
		if (instance == null) {
			instance = new Logger(LogLevel.INFO);
		}
		return instance;
	}

	// 로그 기록
	public void log(String message, LogLevel level) {
		if (level.ordinal() < logLevel.ordinal()) return;
		logQueue.offer(new LogEvent(message, level));
	}

	public void info(String message) { log(message, LogLevel.INFO); }
	public void debug(String message) { log(message, LogLevel.DEBUG); }
	public void warn(String message) { log(message, LogLevel.WARN); }
	public void error(String message) { log(message, LogLevel.ERROR); }

	// 안전 종료
	public void shutdown() throws InterruptedException {
		running = false;
		workerThread.join();
	}

	// Writer 추가 가능
	public void addWriter(LogLevel level, LogWriter writer) {
		writers.get(level).addWriter(writer);
	}
}

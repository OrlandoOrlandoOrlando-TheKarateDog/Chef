package launch;

import java.util.Stack;

@FunctionalInterface
public interface Test extends Runnable {}

enum UnitTest {
	TEST1(() -> {
		report("testing 123");
	});
	
	final Test TASK;
	
	UnitTest(Test test) {
		TASK = test;
	}
	
	private static Stack<String> report = new Stack<>();
	
	private static void report(String message) {
		report.add(message);
	}
	
	static String report() {
		return report.toString();
	}
	
}

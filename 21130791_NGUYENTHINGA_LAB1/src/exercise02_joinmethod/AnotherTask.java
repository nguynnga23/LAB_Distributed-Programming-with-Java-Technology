package exercise02_joinmethod;

public class AnotherTask implements Runnable {
	private String taskName;
	private int counter;

	public AnotherTask(String taskName, int counter) {
		this.taskName = taskName;
		this.counter = counter;
	}

	@Override
	public void run() {
		for (int i = 0; i < counter; i++) {
			System.out.println(taskName + "#" + i);
		}
	}

}

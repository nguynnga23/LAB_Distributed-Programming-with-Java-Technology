package Exercise01;

public class DisplayNumberTask implements Runnable {
	private String taskName;
	
	public DisplayNumberTask(String taskName) {
		super();
		this.taskName = taskName;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(taskName + "# " + i);
		}
	}

	public static void main(String[] args) {
		Runnable r1 = new DisplayNumberTask("Task 1");
		Runnable r2 = new DisplayNumberTask("Task 2");

		Thread t1 = new Thread(r1, "Thread 1");
		Thread t2 = new Thread(r2, "Thread 2");

		t1.start();
		t2.start();
	}

}

/*Trong cùng 1 thread sẽ đảm bảo kết quả trả về 1 cách tuần từ 1-10
 */

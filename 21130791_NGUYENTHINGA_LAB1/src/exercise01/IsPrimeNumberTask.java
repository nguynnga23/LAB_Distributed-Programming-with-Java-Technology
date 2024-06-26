package exercise01;

public class IsPrimeNumberTask implements Runnable {
	private int x;
	private String taskName;

	public IsPrimeNumberTask(int x, String taskName) {
		this.x = x;
		this.taskName = taskName;
	}

	public boolean isPrime() {
		if (x <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(x); i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void run() {
		if (isPrime()) {
			System.out.println(taskName + ": " + x + " là số nguyên tố !");
		} else {
			System.out.println(taskName + ": " + x + " không là số nguyên tố !");
		}
	}

	public static void main(String[] args) {
		Runnable r1 = new IsPrimeNumberTask(7, "Task 1");
		Runnable r2 = new IsPrimeNumberTask(4, "Task 2");

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);

		t1.start();
		t2.start();

	}

}

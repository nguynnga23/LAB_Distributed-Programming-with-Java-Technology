package Exercise02_YieldMethod_vs_DaemonThread;

public class DaemonThreadDemo extends Thread {
	@Override
	public void run() {
		System.out.println("Entering run method");
		try {
			System.out.println("In run Method: currentThread() is " + Thread.currentThread());
			while (true) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
				System.out.println("In run method: woke up again");

			}
		} finally {
			System.out.println("Leaving run Method");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Entering main Method");
		DaemonThreadDemo t = new DaemonThreadDemo();
		
		t.setDaemon(true);
		// Luồng Daemon sẽ bị chấm dứt khi chương trình chính main kết thúc, ngay cả khi
		// luồng "daemon" đó vẫn đang chạy
		

		t.start();
		Thread.sleep(3000);
		System.out.println("Leaving main method");
	}
}

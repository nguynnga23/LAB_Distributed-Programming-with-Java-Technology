package Exercise03;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		Account a = new Account(0, 2309200320032l);

		// Tạo số lượng luồng nạp và rút tiền
		Thread[] depositThreads = new Thread[5];
		Thread[] withdrawThreads = new Thread[5];

		for (int i = 0; i < 5; i++) {
			depositThreads[i] = new Thread(() -> {
//				for (int j = 0; j < 5; j++) {
					a.Deposit(100.0);
//				}
//				System.err.println("End1");
			});
		}

		for (int i = 0; i < 5; i++) {
			withdrawThreads[i] = new Thread(() -> {
//				/for (int j = 0; j < 5; j++) {
					a.Withdraw(100.0);
//				}
//				System.err.println("End2");
			});
		}

		for (Thread thread : depositThreads) {
			thread.start();
		}

		for (Thread thread : withdrawThreads) {
			thread.start();
		}

		// Một vòng lặp sử dụng phương thức join() để chờ tất cả các luồng nạp và rút
		// tiền kết thúc trước khi tiếp tục thực hiện các hành động tiếp theo.

		for (Thread thread : depositThreads) {
			thread.join();
		}

		for (Thread thread : withdrawThreads) {
			thread.join();
		}

//		Runnable r1 = new Runnable() {
//			@Override
//			public void run() {
//				for(int i = 0; i < 10; i++)
//					a.Deposit(100.0);
//			}
//		};
//
//		Runnable r2 = new Runnable() {
//			@Override
//			public void run() {
//				for(int i = 0; i < 5; i++)
//					a.Withdraw(100.0);
//			}
//		};
//
//		Thread t1 = new Thread(r1);
//		Thread t2 = new Thread(r2);
//		t1.start();
//		t2.start();
//
//		System.err.println("End");
		System.out.println("Final Balance: " + a.getBalance());

	}

}

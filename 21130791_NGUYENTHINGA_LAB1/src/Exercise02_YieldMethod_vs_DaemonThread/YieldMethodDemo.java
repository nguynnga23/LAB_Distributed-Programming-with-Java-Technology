package Exercise02_YieldMethod_vs_DaemonThread;

public class YieldMethodDemo implements Runnable {
	private Thread t;

	public YieldMethodDemo(String str) {
		t = new Thread(this, str);
		t.start();
	}

	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			if((i % 5) == 0) {
				System.out.println(Thread.currentThread().getName() + " yielding control ...");
				Thread.yield();
			}
		}
		System.out.println(Thread.currentThread().getName() + " has finished executing.");
	}
	
	public static void main(String[] args) {
		new YieldMethodDemo("Thread 1");
		new YieldMethodDemo("Thread 2");
		new YieldMethodDemo("Thread 3");
		
	}
	
	
}

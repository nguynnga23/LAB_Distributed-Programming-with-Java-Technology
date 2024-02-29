package exercise02__wait_notisy_mechanismdemo;

public class Producer implements Runnable {
	MyQeue q;

	public Producer(MyQeue q) {
		super();
		this.q = q;
		new Thread(this, "Producer").start();
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			q.put(i++);
		}
	}
}

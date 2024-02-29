package exercise02__wait_notisy_mechanismdemo;

public class Consumer implements Runnable {
	MyQeue q;
	Consumer(MyQeue q){
		this.q = q;
		new Thread(this, "Consumer").start();
	}
	@Override
	public void run() {
		while(true) {
			q.get();
		}
	}
}

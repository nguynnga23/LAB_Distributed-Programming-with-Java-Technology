package Exercise02__Wait_Notisy_MechanismDemo;

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

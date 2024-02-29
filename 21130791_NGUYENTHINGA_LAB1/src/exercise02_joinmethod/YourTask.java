package exercise02_joinmethod;

public class YourTask implements Runnable {

	@Override
	public void run() {
		Thread t = new Thread(new AnotherTask("Another task", 10));
		t.start(); 
		for(int i = 0; i < 8; i++) {
			System.out.println("Your Task # " + i);
			if(i == 3)
				try {
					System.out.println(t.getState()); 
					t.join();
					System.out.println(t.getState()); 
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
package exercise01;

//2. The second approach for creating a thread by extending the Thread class (not recommended)
public class ExtendsThreadDemo extends Thread {

	private String taskName;
	private int counter;

	public ExtendsThreadDemo(String taskName, int counter) {
		this.taskName = taskName;
		this.counter = counter;
	}

	@Override
	public void run() {
		for (int i = 0; i < counter; i++) {
			System.out.println("taskName" + "#" + taskName + "#" + i);
		}
	}

	public static void main(String[] args) {
		ExtendsThreadDemo r1 = new ExtendsThreadDemo("Collect Task", 20);
		ExtendsThreadDemo r2 = new ExtendsThreadDemo("Process Task", 23);
//		Thread t1 = new Thread(r1);
//		Thread t2 = new Thread(r2);
		r1.start();
		r2.start();
	}
}

/*
 * Explain why this way was not a recommendation. 
 * 
 * Nếu cho 1 class extend lớp
 * Thread, class đó sẽ không thể extend bất ký class nào khác vì Java không hỗ
 * trợ đa kế thừa.Nhưng nếu implement giao diện Runnable, class vẫn có thể mở
 * rộng các class khác
 * 
 * Mở rộng lớp "Thread" hỗn hợp logic nhiệm vụ với cơ chế xử lý đa luồng, vì
 * logic nhiệm vụ được định nghĩa trong phương thức "run" của luồng
 */

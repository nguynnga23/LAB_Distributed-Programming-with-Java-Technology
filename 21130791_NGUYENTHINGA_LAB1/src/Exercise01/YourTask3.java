package Exercise01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//3. The third approach is implemented Callable interface

public class YourTask3 implements Callable<Long> {

	private String taskName;
	
	
	public YourTask3(String taskName) {
		this.taskName = taskName;
	}

	
	@Override
	public Long call() throws Exception {
		Long result = 0L;
		for(int i = 0; i < 1000; i++) {
			result += i;
			System.out.println(taskName + " #" + i);
			Thread.sleep(10);
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		Callable<Long>call = new YourTask3("long-last-task");
		FutureTask<Long> task = new FutureTask<>(call);
		new Thread(task).start();
		long result = task.get();
		System.out.println("Result: " + result);
	}
	
}


package Exercise02_JoinMethod;

public class TestJoinThread {
	public static void main(String[] args) {
		new Thread(new YourTask()).start();
	}
}

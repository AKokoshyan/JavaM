
public class Test {
	private static int a = 5;

	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				test();
			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				test();
			}
		});

		thread1.start();
		thread2.start();
		System.out.println(a);

	}

	public synchronized static void test() {
		if (a == 6) {
			a = 3;
		}
		a += 5;
	}
}

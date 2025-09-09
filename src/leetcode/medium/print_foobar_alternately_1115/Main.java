package leetcode.medium.print_foobar_alternately_1115;

public class Main {

	public static void main(String[] args) {
		FooBar fooBar = new FooBar(3);

		Thread thread = new Thread(() -> {
			try {
				fooBar.foo(() -> System.out.print("foo"));
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		});

		Thread thread2 = new Thread(() -> {
			try {
				fooBar.bar(() -> System.out.print("bar"));
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		});

		thread.start();
		thread2.start();
	}

}

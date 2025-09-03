package leetcode.easy.print_in_order;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		FooMethodSynchronized fooMethodSynchronized = new FooMethodSynchronized();

		Thread t1 = new Thread(() -> {
			try {
				fooMethodSynchronized.first(() -> System.out.println("fooMethodSynchronized: first"));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		Thread t2 = new Thread(() -> {
			try {
				fooMethodSynchronized.second(() -> System.out.println("fooMethodSynchronized: second"));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		Thread t3 = new Thread(() -> {
			try {
				fooMethodSynchronized.third(() -> System.out.println("fooMethodSynchronized: third"));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		t3.start();
		t2.start();
		t1.start();


		FooObjectLock fooObjectLock = new FooObjectLock();

		Thread t4 = new Thread(() -> {
			try {
				fooObjectLock.first(() -> System.out.println("fooObjectLock: first"));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		Thread t5 = new Thread(() -> {
			try {
				fooObjectLock.second(() -> System.out.println("fooObjectLock: second"));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		Thread t6 = new Thread(() -> {
			try {
				fooObjectLock.third(() -> System.out.println("fooObjectLock: third"));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		t4.start();
		t6.start();
		t5.start();


		/* Not yet working */
		FooSemaphore fooSemaphore = new FooSemaphore();

		Thread t7 = new Thread(() -> {
			try {
				fooSemaphore.first(() -> System.out.println("fooSemaphore: first"));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		Thread t8 = new Thread(() -> {
			try {
				fooSemaphore.second(() -> System.out.println("fooSemaphore: second"));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		Thread t9 = new Thread(() -> {
			try {
				fooSemaphore.third(() -> System.out.println("fooSemaphore: third"));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		t7.start();
		t9.start();
		t8.start();
	}

}

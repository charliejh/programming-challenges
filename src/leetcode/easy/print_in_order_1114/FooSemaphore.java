package leetcode.easy.print_in_order_1114;

import java.util.concurrent.Semaphore;

public class FooSemaphore {

	private Semaphore semaphore;

	public FooSemaphore() {
		semaphore = new Semaphore(1, true);
	}

	public void first(Runnable printFirst) throws InterruptedException {
		semaphore.acquire();
		printFirst.run();
		semaphore.release();
	}

	public void second(Runnable printSecond) throws InterruptedException {
		semaphore.acquire();
		printSecond.run();
		semaphore.release();
	}

	public void third(Runnable printThird) throws InterruptedException {
		semaphore.acquire();
		printThird.run();
		semaphore.release();
	}

}

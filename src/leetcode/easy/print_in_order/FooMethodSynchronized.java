package leetcode.easy.print_in_order;

class FooMethodSynchronized {

	private boolean oneComplete;
	private boolean twoComplete;

	public FooMethodSynchronized() {}

	public synchronized void first(Runnable printFirst) throws InterruptedException {
		printFirst.run();
		oneComplete = true;
		notifyAll();
	}

	public synchronized void second(Runnable printSecond) throws InterruptedException {
		while (!oneComplete) {
			wait();
		}
		printSecond.run();
		twoComplete = true;
		notifyAll();
	}

	public synchronized void third(Runnable printThird) throws InterruptedException {
		while (!twoComplete) {
			wait();
		}
		printThird.run();
		notifyAll();
	}
}
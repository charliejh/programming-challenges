package leetcode.easy.print_in_order;

public class FooObjectLock {

		private final Object lock;
		private boolean oneComplete;
		private boolean twoComplete;

		public FooObjectLock() {
			lock = new Object();
		}

		public void first(Runnable printFirst) throws InterruptedException {
			synchronized (lock) {
				printFirst.run();
				oneComplete = true;
				lock.notifyAll();
			}
		}

		public void second(Runnable printSecond) throws InterruptedException {
			synchronized (lock) {
				while (!oneComplete) {
					lock.wait();
				}
				printSecond.run();
				twoComplete = true;
				lock.notifyAll();
			}
		}

		public void third(Runnable printThird) throws InterruptedException {
			synchronized (lock) {
				while (!twoComplete) {
					lock.wait();
				}
				printThird.run();
				lock.notifyAll();
			}
		}

}

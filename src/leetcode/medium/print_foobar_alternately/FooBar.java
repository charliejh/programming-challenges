package leetcode.medium.print_foobar_alternately;

class FooBar {

	private int n;
	private boolean fooPrinted;

	public FooBar(int n) {
		this.n = n;
	}

	public synchronized void foo(Runnable printFoo) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			while (fooPrinted) {
				wait();
			}
			printFoo.run();
			fooPrinted = true;
			notifyAll();
		}
	}

	public synchronized void bar(Runnable printBar) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			while (!fooPrinted) {
				wait();
			}
			printBar.run();
			fooPrinted = false;
			notifyAll();
		}
	}
}

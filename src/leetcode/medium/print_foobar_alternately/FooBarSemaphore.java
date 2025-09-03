package leetcode.medium.print_foobar_alternately;

import java.util.concurrent.Semaphore;

public class FooBarSemaphore {

	private final int n;
	private final Semaphore fooTurn = new Semaphore(1); // foo goes first
	private final Semaphore barTurn = new Semaphore(0); // bar waits

	public FooBarSemaphore(int n) {
		this.n = n;
	}

	public void foo(Runnable printFoo) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			fooTurn.acquire();          // wait for our turn
			printFoo.run();             // print without newline
			barTurn.release();          // let bar run next
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			barTurn.acquire();          // wait for foo
			printBar.run();             // print without newline
			fooTurn.release();          // hand back to foo
		}
	}

}

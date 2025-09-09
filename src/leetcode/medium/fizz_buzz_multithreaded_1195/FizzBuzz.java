package leetcode.medium.fizz_buzz_multithreaded_1195;

import java.util.function.IntConsumer;

public class FizzBuzz {

	private int n;
	private int intToPrint;

	public FizzBuzz(int n) {
		this.n = n;
		this.intToPrint = 1;
	}

	// printFizz.run() outputs "fizz".
	public synchronized void fizz(Runnable printFizz) throws InterruptedException {
		while (intToPrint <= n) {
			if(intToPrint % 3 == 0 && intToPrint % 5 != 0) {
				printFizz.run();
				intToPrint++;
				notifyAll();
			} else {
				wait();
			}
		}

	}

	// printBuzz.run() outputs "buzz".
	public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
		while (intToPrint <= n) {
			if(intToPrint % 5 == 0 && intToPrint % 3 != 0) {
				printBuzz.run();
				intToPrint++;
				notifyAll();
			} else {
				wait();
			}
		}
	}

	// printFizzBuzz.run() outputs "fizzbuzz".
	public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		while (intToPrint <= n) {
			if(intToPrint % 5 == 0 && intToPrint % 3 == 0) {
				printFizzBuzz.run();
				intToPrint++;
				notifyAll();
			} else {
				wait();
			}
		}
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public synchronized void number(IntConsumer printNumber) throws InterruptedException {
		while (intToPrint <= n) {
			if(intToPrint % 5 != 0 && intToPrint % 3 != 0) {
				printNumber.accept(intToPrint);
				intToPrint++;
				notifyAll();
			} else {
				wait();
			}
		}
	}

}

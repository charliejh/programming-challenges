package leetcode.medium.fizz_buzz_multithreaded_1195;

import java.util.function.IntConsumer;

public class Main {

	public static void main(String[] args) {

		int n = 15;
		FizzBuzz fb = new FizzBuzz(n);

		Thread tFizz = new Thread(() -> {
			try {
				fb.fizz(() -> System.out.print("fizz "));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		Thread tBuzz = new Thread(() -> {
			try {
				fb.buzz(() -> System.out.print("buzz "));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		Thread tFizzBuzz = new Thread(() -> {
			try {
				fb.fizzbuzz(() -> System.out.print("fizzbuzz "));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		Thread tNumber = new Thread(() -> {
			try {
				fb.number((IntConsumer) x -> System.out.print(x + " "));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		tFizz.start();
		tBuzz.start();
		tFizzBuzz.start();
		tNumber.start();

		System.out.println();
	}

}

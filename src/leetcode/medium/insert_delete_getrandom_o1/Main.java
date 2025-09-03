package leetcode.medium.insert_delete_getrandom_o1;

public class Main {

	public static void main(String[] args) {
		RandomizedSet randomizedSet = new RandomizedSet();

		randomizedSet.insert(1);
		System.out.println(randomizedSet);
		randomizedSet.insert(2);
		System.out.println(randomizedSet);
		randomizedSet.insert(3);
		System.out.println(randomizedSet);
		randomizedSet.insert(3);
		System.out.println(randomizedSet);
		randomizedSet.insert(5);
		System.out.println(randomizedSet);
		randomizedSet.insert(4);
		System.out.println(randomizedSet);
		randomizedSet.insert(6);
		System.out.println(randomizedSet);

		randomizedSet.remove(2);
		System.out.println(randomizedSet);

		System.out.println(randomizedSet.getRandom());
	}

}

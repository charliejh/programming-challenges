package leetcode.medium.insert_delete_getrandom_o1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {

	private List<Integer> values;
	private Map<Integer,Integer> position;
	private final Random random;

	public RandomizedSet() {
		this.values = new ArrayList<>();
		this.position = new HashMap<>();
		this.random = new Random();
	}

	public boolean insert(int val) {
		if(this.position.containsKey(val)) {
			return false;
		}
		// add to the end of the list
		this.values.add(val);
		// set the position of the int in the map to the the last index in the list
		this.position.put(val, this.values.size() - 1);
		return true;
	}

	public boolean remove(int val) {
		// check if the int has a position in the map and return false if it's not present
		Integer postionOfVal = position.get(val);
		System.out.println(postionOfVal);
		if(postionOfVal == null) {
			return false;
		}

		// grab the int in the last index of the array
		int lastValue = values.getLast();
		System.out.println(lastValue);
		// set the position of the last int in the array to the position of the value being removed
		values.set(postionOfVal, lastValue);
		// update the position of the last value to the position of the int being removed in the map
		position.put(lastValue, postionOfVal);
		// remove the last value since it has been set in the other position
		values.removeLast();
		// remove the int from the position map
		position.remove(val);

		return true;
	}

	public int getRandom() {
		return values.get(random.nextInt(values.size()));
	}

	@Override
	public String toString() {
		return values.toString();
	}

}

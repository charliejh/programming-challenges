package RedditChallenge_329_WaterBucketRiddle;

import java.util.ArrayList;

/**
 * NOT COMPLETED YET
 */

public class WaterBucketRiddle {

    static ArrayList<ArrayList<Integer>> states = new ArrayList<>();

    public static void main(String[] args) {
        Bucket a = new Bucket(3);
        Bucket b = new Bucket(5);

        /** Example of a working solution */
        b.fill();
        b.transfer(a);
        a.empty();
        b.transfer(a);
        b.fill();
        b.transfer(a);

        solve(a, b, 4);
    }

    public static boolean solve(Bucket a, Bucket b, int goal) {
        states.clear();
        if(a.getWater() == goal || b.getWater() == goal) {
            return true;
        }
        if(!states.contains(addStates(a.getWater(), b.getWater()))) {
            states.add(addStates(a.getWater(), b.getWater()));
        }
        return false;
    }

    public static ArrayList<Integer> addStates(int aValue, int bValue){
        ArrayList<Integer> state = new ArrayList<>();
        state.add(aValue);
        state.add(bValue);
        return state;
    }

}

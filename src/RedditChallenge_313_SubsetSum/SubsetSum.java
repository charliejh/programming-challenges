package RedditChallenge_313_SubsetSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SubsetSum {

    /**
     * Main method that takes the argument and prints the result
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Subset Sum #313");
        System.out.println("Enter an integer or f to finish");
        while (true) {
            System.out.print("Input: ");
            String input = sc.next();
            if (input.equals("f")) {
                break;
            }
            else {
                list.add(Integer.parseInt(input));
            }
        }
        Collections.sort(list);
        System.out.println(list + " -> " + sum(list));
    }

    /**
     * Checks the list and returns true or false depending on the values in the list
     * @param list is the list of integers entered as via the main method input
     * @return returns true if a 0 is present in the list or if the sum of two numbers in the list are 0
     *         else returns false
     */
    static boolean sum(ArrayList<Integer> list) {
        if (list.size() == 0) return false;
        if (list.contains(0)) return true;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (list.get(i) + list.get(j) == 0) return true;
            }
        }
        return false;
    }

}

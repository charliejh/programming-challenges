package Challenge_323_ThreeSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ThreeSum {

    private static ArrayList<String> list = new ArrayList<>();

    /**
     * Main method that takes the argument and calls the threeSum method
     */
    public static void main(String[] args) {
        System.out.println("3SUM #323\nEnter an integer, 'c' to check, or 'e' to exit.\n");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Input: ");
            String input = sc.next();
            if (input.equals("c")) {
                threeSum(list);
                list.clear();
                System.out.println();
            }
            else if(input.equals("e")) {
                System.out.println("Exiting program...");
                break;
            }
            else {
                list.add(input);
            }
        }
    }

    /**
     * Takes 3 integers from the list and checks the the sum is 0
     * Uses the 3SUM algorithm: https://en.wikipedia.org/wiki/3SUM
     * @param inputList is the list of integers passed via the main method
     * O(n)2 time complexity
     */
    private static void threeSum(ArrayList<String> inputList) {
        boolean equalsZero = false;
        int a, b, c, n, start, end;
        ArrayList<Integer> newList = convertListToInt(inputList);
        n = newList.size();
        for (int i = 0; i < n - 2; i++) {
            a = newList.get(i);
            start = i + 1;
            end = n - 1;
            while (start < end) {
                b = newList.get(start);
                c = newList.get(end);
                if (a + b + c == 0) {
                    System.out.println(a + " " + b + " " + c +  " make 0");
                    equalsZero = true;
                    end--;
                }
                else if (a + b + c < 0) {
                    start++;
                }
                else {
                    end--;
                }
            }
        }
        if (!equalsZero) {
            System.out.println("No 3 values make the sum of 0");
        }
    }

    /**
     * @param list The ArrayList of String values
     * @return newList An ArrayList of Integer values
     */
    private static ArrayList<Integer> convertListToInt(ArrayList<String> list) {
        ArrayList<Integer> newList = new ArrayList<>();
        for (String s : list) {
            newList.add(Integer.parseInt(s));
        }
        Collections.sort(newList);
        return newList;
    }

}

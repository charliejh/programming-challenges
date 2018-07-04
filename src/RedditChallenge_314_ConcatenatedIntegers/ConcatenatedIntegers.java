package RedditChallenge_314_ConcatenatedIntegers;

import java.util.*;

public class ConcatenatedIntegers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Concatenated Integers #314");
        while (true) {
            System.out.print("Enter an integer or enter f to finish: ");
            String input = sc.next();
            if (input.equals("f")) {
                break;
            } else {
                list.add(input);
            }
        }
        System.out.print("\nList: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.print("Smallest: ");
        ArrayList<String> smallestList = smallest(list);
        for (int i = 0; i < smallestList.size(); i++) {
            System.out.print(smallestList.get(i));
        }
        System.out.println();
        System.out.print("Biggest: ");
        ArrayList<String> biggestList = biggest(list);
        for (int i = 0; i < biggestList.size(); i++) {
            System.out.print(biggestList.get(i));
        }
        System.out.println();
    }

    /**
     *
     * @param list is the input list from the main method that is passed via smallest/biggest
     * @return paddedList which contains a new ArrayList full of padded numbers
     */
    public static ArrayList<String> padNumbers(ArrayList<String> list) {
        /**
         * finds the length of the largest integer
         */
        int largest = list.get(0).length();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).length() > largest) {
                largest = list.get(i).length();
            }
        }
        /**
         * copies the input list into paddedList and pads all integers to the same size with the last integer
         */
        ArrayList<String> paddedList = (ArrayList<String>)list.clone();
        for (int i = 0; i < paddedList.size(); i++) {
            if (paddedList.get(i).length() < largest) {
                while (paddedList.get(i).length() < largest) {
                    paddedList.set(i, paddedList.get(i) + (paddedList.get(i).substring(paddedList.get(i).length() - 1)));
                }
            }
        }
        return paddedList;
    }

    /**
     * @param list is the input list from the main method
     * @return an ArrayList of the input values in order for the smallest number
     */
    public static ArrayList<String> smallest(ArrayList<String> list) {
        ArrayList<String> paddedList = padNumbers(list);
        /**
         * copies paddedList into sortedList and sorts sortedList ascending
         */
        ArrayList<String> sortedList = (ArrayList<String>)paddedList.clone();
        Collections.sort(sortedList);
        /**
         * takes the first value in sortedList list
         * finds the index of that value in paddedList
         * then adds the value at the index from list into result
         */
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < sortedList.size(); i++) {
            String s = sortedList.get(i);
            int index = paddedList.indexOf(s);
            result.add(list.get(index));
        }
        return result;
    }

    /**
     * @param list is the input list from the main method
     * @return an ArrayList of the input values in order for the biggest number
     */
    public static ArrayList<String> biggest(ArrayList<String> list) {
        ArrayList<String> paddedList = padNumbers(list);
        /**
         * copies paddedList into sortedList and sorts sortedList descending
         */
        ArrayList<String> sortedList = (ArrayList<String>)paddedList.clone();
        Collections.sort(sortedList);
        Collections.reverse(sortedList);
        /**
         * takes the first value in sortedList list
         * finds the index of that value in paddedList
         * then adds the value at the index from list into result
         */
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < sortedList.size(); i++) {
            String s = sortedList.get(i);
            int index = paddedList.indexOf(s);
            result.add(list.get(index));
        }

        return result;
    }

}

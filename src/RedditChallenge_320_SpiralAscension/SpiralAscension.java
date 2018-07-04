package RedditChallenge_320_SpiralAscension;

import java.util.Scanner;

public class SpiralAscension {

    private static int[][] spiral;

    /**
     * Main method that takes the argument and prints the result
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Spiral Ascension #320");
        while (true) {
            System.out.print("Enter the size of n*n spiral or press 0 to exit: ");
            int size = sc.nextInt();
            if (size == 0) {
                break;
            }
            spiral = new int[size][size];
            createSpiral(size);
            System.out.println();
            for (int[] row : spiral) {
                for (int i : row) {
                    System.out.print(i);
                    System.out.print("\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    /**
     * Places the values inside the spiral 2D array
     * @param size is the size of the n*n spiral
     */
    private static void createSpiral(int size){
        int n = 0;
        int row = 0;
        int col = 0;
        int count = 1;
        /**
         * Adds the values to the top row of the spiral
         */
        for (int i = 0; i < size; i++) {
            n++;
            spiral[row][col] = n;
            if (col < size - 1) col++;
        }
        /**
         * Adds values down, left, up and right in a loop
         */
        while (n < size * size) {
            for (int i = 0; i < size - count; i++) {
                n++;
                row++;
                spiral[row][col] = n;
            }
            for (int i = 0; i < size - count; i++) {
                n++;
                col--;
                spiral[row][col] = n;
            }
            count++;
            for (int i = 0; i < size - count; i++) {
                n++;
                row--;
                spiral[row][col] = n;
            }
            for (int i = 0; i < size - count; i++) {
                n++;
                col++;
                spiral[row][col] = n;
            }
            count++;
        }
    }

}

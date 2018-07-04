package RedditChallenge_340_WalkInAMinefield;

import java.util.Scanner;

public class WalkInAMinefield {

    /** The minefield */
    static String[][] minefield = { {"+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+"},
                                    {"+", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                                    {"+", "0", "0", "0", "0", "0", "0", "*", "0", "0", "+"},
                                    {"+", "0", "0", "0", "0", "0", "0", "0", "0", "0", "+"},
                                    {"+", "0", "0", "0", "*", "0", "0", "*", "0", "0", "+"},
                                    {"+", "0", "0", "0", "0", "0", "0", "0", "0", "0", "+"},
                                    {"R", "0", "0", "0", "*", "0", "0", "0", "0", "0", "+"},
                                    {"+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+"}
    };

    /**
     * Ensures the game is set to true before asking for user input - game boolean
     * The robot will not be able to move if he is blown up by a mine - broken boolean
     * THe robot will not be able to move if it's engine is off - engine boolean
     * The robot is moved depending on the users input
     * To finish the user must ideally turn the engine off and press Enter to finish
     */
    public static void main(String[] args) {
        int row = 6;
        int col = 0;
        boolean engine = false;
        boolean broken = false;
        boolean game = true;
        Scanner sc = new Scanner(System.in);
        minefieldToString();
        System.out.println("N - North | E - East | S - South | W - West | G - Start Engine | D - Stop Engine | Enter - Finish");
        while (game) {
            System.out.print("Input:");
            String input = sc.nextLine().toUpperCase();
            try {
                switch (input) {
                    case "N":
                        if (engine && !broken) {
                            if (minefield[row - 1][col].contains("+")) {
                                continue;
                            } else if (minefield[row - 1][col].contains("0")) {
                                minefieldUpdate(row - 1, col, col, row);
                                row--;
                            } else if (minefield[row - 1][col].contains("*")) {
                                minefieldUpdate(row - 1, col, col, row);
                                row--;
                                broken = true;
                            }
                        }
                        break;
                    case "E":
                        if (engine && !broken) {
                            if (minefield[row][col + 1].contains("+")) {
                                continue;
                            } else if (minefield[row][col + 1].contains("0")) {
                                minefieldUpdate(row, col + 1, col, row);
                                col++;
                            } else if (minefield[row][col + 1].contains("*")) {
                                minefieldUpdate(row, col + 1, col, row);
                                col++;
                                broken = true;
                            }
                        }
                        break;
                    case "S":
                        if (engine && !broken) {
                            if (minefield[row + 1][col].contains("+")) {
                                continue;
                            } else if (minefield[row + 1][col].contains("0")) {
                                minefieldUpdate(row + 1, col, col, row);
                                row++;
                            } else if (minefield[row + 1][col].contains("*")) {
                                minefieldUpdate(row + 1, col, col, row);
                                row++;
                                broken = true;
                            }
                        }
                        break;
                    case "W":
                        if (engine && !broken) {
                            if (minefield[row][col - 1].contains("+")) {
                                continue;
                            } else if (minefield[row][col - 1].contains("0")) {
                                minefieldUpdate(row, col - 1, col, row);
                                col--;

                            } else if (minefield[row][col - 1].contains("*")) {
                                minefieldUpdate(row, col - 1, col, row);
                                col--;
                                broken = true;
                            }
                        }
                        break;
                    case "G":
                        engine = true;
                        break;
                    case "D":
                        engine = false;
                        break;
                    case "":
                        game = false;
                        break;
                    default:
                        System.out.println("Invalid input. Try again...");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) { }
        }
        if (row == 1 && col == 10 && !engine) {
            System.out.println("\nYou win!");
        }
        else {
            System.out.println("\nYou lose!");
        }
        minefieldToString();
    }

    /**
     * Updates minefield using the robots new location and previous
     */
    static void minefieldUpdate(int row, int col, int prevCol, int prevRow) {
        minefield[prevRow][prevCol] = " ";
        minefield[row][col] = "R";

    }

    /**
     * Prints the minefield to the screen
     */
    static void minefieldToString() {
        for (String[] rows : minefield) {
            for (String i : rows) {
                System.out.print(i);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

}

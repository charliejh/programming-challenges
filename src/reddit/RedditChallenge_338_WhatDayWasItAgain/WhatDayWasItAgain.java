package reddit.RedditChallenge_338_WhatDayWasItAgain;

import java.util.Scanner;

public class WhatDayWasItAgain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What Day Was It Again #338");
        while (true) {
            System.out.print("Input a date in the format YYYY/MM/DD or hit 'Enter' to exit: ");
            String input = sc.nextLine();
            if (input.equals("")) break;
            int day = Integer.parseInt(input.substring(8, 10));
            int month = Integer.parseInt(input.substring(5, 7));
            int year = Integer.parseInt(input.substring(0, 4));

            /**
             * Using Zeller's algorithm: https://en.wikipedia.org/wiki/Zeller's_congruence
             */
            int whatday = (day + (13 * (month + 1) / 5) + year + (year / 4) - (year / 100) + (year / 400)) % 7;
            switch (whatday) {
                case 0:
                    System.out.println("Saturday");
                    break;
                case 1:
                    System.out.println("Sunday");
                    break;
                case 2:
                    System.out.println("Monday");
                    break;
                case 3:
                    System.out.println("Tuesday");
                    break;
                case 4:
                    System.out.println("Wednesday");
                    break;
                case 5:
                    System.out.println("Thursday");
                    break;
                case 6:
                    System.out.println("Friday");
                    break;
            }
        }
    }

}

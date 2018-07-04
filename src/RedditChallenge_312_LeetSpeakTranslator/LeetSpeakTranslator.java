package RedditChallenge_312_LeetSpeakTranslator;

import java.util.Scanner;

public class LeetSpeakTranslator {

    private static final String[] NORM = {"v", "a", "b", "e", "l", "m", "n", "o", "s", "t", "w"};
    private static final String[] LEET = {"\\/", "4", "6", "3", "1", "(v)", "(\\)", "0", "5", "7", "'//"};

    public static void main(String[] args) {
        System.out.println("1337 Speak Translator #312\nEnter phrase to translate or press 'Enter' to exit.");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Input: ");
            String input = sc.nextLine();
            if (input.equals("")){
                break;
            }
            translateToLeet(input.toLowerCase());
            translateToNorm(input.toLowerCase());
            System.out.println();
        }
    }

    private static void translateToLeet(String input) {
        String result = "";
        String temp = input;
        for (int i = 0; i < NORM.length; i++) {
            result = temp.replace(NORM[i], LEET[i]);
            temp = result;
        }
        if (result.contains("(\\/)")) {
            result = result.replace("(\\/)", "(v)");
        }
        System.out.println("1337: " + result);
    }

    private static void translateToNorm(String input) {
        String result = "";
        String temp = input;
        for (int i = 0; i < LEET.length; i++) {
            result = temp.replace(LEET[i], NORM[i]);
            temp = result;
        }
        System.out.println("Normal: " + result);
    }

}

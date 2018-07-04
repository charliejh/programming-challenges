package RedditChallenge_302_SpellingWithChemistry;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SpellingWithChemistry {

    /** ArrayList that contains elements from the CSV file */
    private static ArrayList<Element> elements;

    public static void main(String[] args) {
        System.out.println("Spelling With Chemistry #302");
        elements = readElementsCSV("src/RedditChallenge_302_SpellingWithChemistry/Elements.csv");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Word: ");
            String word = scanner.nextLine().toLowerCase();
            if (word.equals("")) break;
            checkWord(word);
        }
    }

    /**
     * Determines if the word can be spelt with the Elements symbols
     * @param word The input word
     * @return Boolean
     */
    public static boolean checkWord(String word) {
        if (elements.isEmpty()) return false;
        if (word.equals("")) return false;
        String currentWord = "";
        String originalWord = word;
        for (int i = 0; i < word.length(); i++) {
            currentWord = currentWord.concat(i + "");
        }
        ArrayList<String> elementsUsed = new ArrayList<>();
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.substring(i, i + 1).equals("*")) continue;
            for (Element e : elements) {
                if (e.getSYMBOL().toLowerCase().equals(word.substring(i, i + 2))) {
                    elementsUsed.add(e.getNAME());
                    currentWord = currentWord.replace(currentWord.substring(word.indexOf(e.getSYMBOL().toLowerCase()), word.indexOf(e.getSYMBOL().toLowerCase()) + 2), e.getSYMBOL());
                    word = word.replaceFirst(e.getSYMBOL().toLowerCase(), "**");
                }
            }
        }
        for (int i = 0; i < word.length(); i++) {
            if (word.substring(i, i + 1).equals("*")) continue;
            for (Element e : elements) {
                if (e.getSYMBOL().toLowerCase().equals(word.substring(i, i + 1))) {
                    elementsUsed.add(e.getNAME());
                    currentWord = currentWord.replace(currentWord.substring(word.indexOf(e.getSYMBOL().toLowerCase()), word.indexOf(e.getSYMBOL().toLowerCase()) + 1), e.getSYMBOL());
                    word = word.replaceFirst(e.getSYMBOL().toLowerCase(), "+");
                }
            }
        }
        if (currentWord.toLowerCase().equals(originalWord)) {
            System.out.print(currentWord);
            System.out.print(" ( ");
            for (String e : elementsUsed) {
                System.out.print(e + " ");
            }
            System.out.println(")");
        }
        else {
            System.out.println("Word cannot be spelt");
        }
        return currentWord.toLowerCase().equals(originalWord);
    }

    /**
     * Reads the CSV file, creates Element objects and adds them to an ArrayList
     * @param inputFilePath The location of the CSV file
     * @return An ArrayList full of Element objects
     */
    public static ArrayList<Element> readElementsCSV(String inputFilePath) {
        ArrayList<Element> elements = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].contains("Element")) continue;
                if (values.length == 5) {
                    elements.add(new Element(values[0], values[1], values[3], Integer.parseInt(values[2]), Float.parseFloat(values[4])));
                }
                else {
                    elements.add(new Element(values[0], values[1], values[3], Integer.parseInt(values[2])));
                }
            }
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return elements;
    }

}

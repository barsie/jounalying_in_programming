package Assignments;

import java.util.*;

public class TextAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. User Input
        System.out.println("Introduce a paragraph or lengthy text:");
        String inputText = scanner.nextLine();

        // Character Count
        int characterCount = inputText.length();
        System.out.println("\n This " + inputText + "has a total Characters of: " + characterCount);

        // Word Count
        String[] words = inputText.trim().split("\\s+");
        int wordCount = words.length;
        System.out.println("Total Words: " + wordCount + " words");

        // 3. Most Common Character
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (char c : inputText.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);
            }
        }

        char mostCommonChar = ' ';
        int maxCharCount = 0;
        for (Map.Entry<Character, Integer> entry : charFreqMap.entrySet()) {
            if (entry.getValue() > maxCharCount) {
                maxCharCount = entry.getValue();
                mostCommonChar = entry.getKey();
            }
        }

        System.out.println("Most Common Character: " + mostCommonChar + " (appears " + maxCharCount + " times)");

        // 4. Character Frequency
        System.out.print("\nEnter a character to check its frequency: ");
        char userChar = scanner.next().toLowerCase().charAt(0);
        int userCharCount = 0;
        for (char c : inputText.toLowerCase().toCharArray()) {
            if (c == userChar) {
                userCharCount++;
            }
        }
        System.out.println("Character '" + userChar + "' appears " + userCharCount + " times.");

        scanner.nextLine();

        //5. Word Frequency        System.out.print("\nEnter a word to check its frequency: ");
        String userWord = scanner.nextLine().toLowerCase();
        int wordFreq = 0;
        for (String word : words) {
            if (word.toLowerCase().equals(userWord)) {
                wordFreq++;
            }
        }
        System.out.println("Word \"" + userWord + "\" appears " + wordFreq + " times.");

        // Unique Words
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word.toLowerCase());
        }
        System.out.println("\n Number of Unique Words: " + uniqueWords.size());

        scanner.close();
    }
}

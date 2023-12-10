import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the file path
        System.out.print("Enter the path of the text file: ");
        String filePath = scanner.nextLine();

        try {
            // Read the file
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);

            // Variables for word count and total word length
            int wordCount = 0;
            int totalWordLength = 0;

            // Map to store word frequency
            Map<String, Integer> wordFrequency = new HashMap<>();

            // Process each word in the file
            while (fileScanner.hasNext()) {
                String word = fileScanner.next().toLowerCase(); // Convert to lowercase for case-insensitive counting
                word = word.replaceAll("[^a-zA-Z]", ""); // Remove non-alphabetic characters

                // Update word count and total word length
                if (!word.isEmpty()) {
                    wordCount++;
                    totalWordLength += word.length();

                    // Update word frequency
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }

            // Calculate average word length
            double avgWordLength = (double) totalWordLength / wordCount;

            // Display results
            System.out.println("Word Count: " + wordCount);
            System.out.println("Average Word Length: " + avgWordLength);
            System.out.println("Frequency of the word:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            // Close the file scanner
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found. Please check the file path and try again.");
        }
    }
}
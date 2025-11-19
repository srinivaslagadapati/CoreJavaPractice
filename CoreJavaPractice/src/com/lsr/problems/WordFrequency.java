package com.lsr.problems;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class WordFrequency {

    public Map<String, Integer> getWordFrequency(String text) {
        if (text == null || text.trim().isEmpty()) {
            return new HashMap<>();
        }

        // 1. Convert to lowercase and remove non-alphanumeric characters
        // This regex replaces anything that isn't a letter or number with a space
        String processedText = text.toLowerCase().replaceAll("[^a-z0-9 ]", " ");

        // 2. Split the processed string into words
        String[] words = processedText.split("\\s+"); // Split by one or more spaces

        // 3. Create a map to store word frequencies
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        // 4. Iterate and count word frequencies
        for (String word : words) {
            // Handle any empty strings that may result from the split
            if (!word.isEmpty()) {
                // getOrDefault is a concise way to handle the logic
                wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
            }
        }

        return wordFrequencyMap;
    }

    public static void main(String[] args) {
        WordFrequency solution = new WordFrequency();
        String text = "The quick, brown fox jumps over the lazy dog. The quick fox!";

        Map<String, Integer> frequencyMap = solution.getWordFrequency(text);

        // Print the results
        System.out.println("Word Frequencies:");
        frequencyMap.forEach((word, count) ->
            System.out.println("'" + word + "': " + count)
        );
        frequencyMap.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue));
        // Step 1: Find the maximum frequency value
        Optional<Integer> maxFrequency = frequencyMap.values()
            .stream()
            .max(Integer::compareTo);
      
    }
}
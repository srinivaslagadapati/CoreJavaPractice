package com.lsr.problems;

import java.io.IOException;

public class getLongestIncreasingSubstring {
    public static void main(String[] args) throws IOException {
        String input = "orpstangeappleofff";
        System.out.println("Input string: " + input);

        String result = getLongestIncreasingSubstring(input);
        System.out.println("Longest increasing substring: " + result);
    }

    public static String getLongestIncreasingSubstring(String s) {
        int n = s.length();
        if (n == 0) {
            System.out.println("Empty string received");
            return "";
        }

        int maxLength = 1;
        int currentLength = 1;
        int start = 0;          // start index of current substring
        int maxStart = 0;       // start index of max substring

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) > s.charAt(i - 1)) {
                currentLength++;
                System.out.println("Increasing char '" + s.charAt(i) + "' at index " + i + ", currentLength = " + currentLength);
            } else {
                System.out.println("Reset at char '" + s.charAt(i) + "' at index " + i);
                currentLength = 1;
                start = i;
            }
            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxStart = start;
                System.out.println("New max substring from index " + maxStart + " to " + (maxStart + maxLength - 1) + ", length = " + maxLength);
            }
        }
        return s.substring(maxStart, maxStart + maxLength);
    }
}

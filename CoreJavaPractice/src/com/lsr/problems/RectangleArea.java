package com.lsr.problems;

import java.util.*;

public class RectangleArea {
    private static final int MOD = 1000000007;

	public static int getMaxTotalArea(int[] sideLengths) {
		Map<Integer, Integer> countMap = new HashMap<>();

		// Count occurrences of each stick length
		for (int length : sideLengths) {
			countMap.put(length, countMap.getOrDefault(length, 0) + 1);
		}

		// List to hold available lengths
		int[] availableLengths = new int[countMap.size()];
		int index = 0;

		// Prepare an array of lengths
		for (int length : countMap.keySet()) {
			availableLengths[index++] = length;
		}

		// Sort the lengths
		java.util.Arrays.sort(availableLengths);

		int totalArea = 0;
		int pairsCount = 0;
		int lastLength = -1;

		// Iterate over the sorted lengths to form rectangles
		for (int i = availableLengths.length - 1; i >= 0; i--) {
			int length = availableLengths[i];
			int count = countMap.get(length) / 2; // Number of pairs available
			pairsCount += count;

			if (count > 0) {
				// Try to form a rectangle with the last length if we have enough pairs
				if (lastLength != -1) {
					totalArea = (totalArea + (length * lastLength) % MOD) % MOD;
					pairsCount--; // Use one pair from current length and last length
					lastLength = -1; // Reset last length after using it
				} else {
					// If no pair can be formed yet, save this length for later
					lastLength = length;
				}
			}
		}

		// Handle the case where we can reduce one of the last lengths
		if (lastLength != -1) {
			for (int i = 0; i < availableLengths.length; i++) {
				int length = availableLengths[i];
				if (length > 1 && countMap.getOrDefault(length - 1, 0) > 0) {
					totalArea = (totalArea + (lastLength * (length - 1)) % MOD) % MOD;
					break; // Stop after finding the first valid reduction
				}
			}
		}

		return totalArea;}

    public static void main(String[] args) {
        int[] sideLengths1 = {2, 3, 3, 4, 6, 8, 8, 6};
        System.out.println(getMaxTotalArea(sideLengths1)); // Output: 54

        int[] sideLengths2 = {3, 4, 5, 5, 6};
        System.out.println(getMaxTotalArea(sideLengths2)); // Output: 20
    }
}


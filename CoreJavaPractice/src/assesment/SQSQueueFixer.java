package assesment;

import java.util.*;

import java.util.*;

public class SQSQueueFixer {
    public static int getMinInsertion(List<Integer> messages) {
        Set<Integer> seenSums = new HashSet<>();
        seenSums.add(0); // Base case for detecting zero-sum subarrays

        int result = 0;
        int runningSum = 0;

        for (int num : messages) {
            runningSum += num;

            // If the running sum has been seen before, we have a zero-sum subarray
            if (seenSums.contains(runningSum)) {
                result++; // Increment insertions count
                
                // Modify running sum to break the pattern
                runningSum += 100; 

                // Reset seen sums
                seenSums.clear();
                seenSums.add(0);
            }

            seenSums.add(runningSum);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> messages = Arrays.asList(4, 3, -2, -1, 1);
        System.out.println(getMinInsertion(messages)); // Expected Output: 2
    }
}

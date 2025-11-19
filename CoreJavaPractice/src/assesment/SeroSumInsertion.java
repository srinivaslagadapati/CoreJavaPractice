package assesment;

import java.util.*;

public class SeroSumInsertion {
    public static int getMinInsertion(List<Integer> messages) {
        Set<Integer> seenSums = new HashSet<>();
        seenSums.add(0); // Base case for detecting zero-sum subarrays
        System.out.println(" messages "+messages);
        int result = 0;
        int runningSum = 0;
        for (int num : messages) {
            runningSum += num;
            System.out.println(" num  "+num);
            System.out.println(" runningSum  "+runningSum);
            // If runningSum has been seen before, we must insert to break the zero-sum pattern
            if (seenSums.contains(runningSum)) {
                result++; // Increment insertions count
                
                // Instead of adding an arbitrary value, reset the running sum
                runningSum = num; 
                System.out.println(" runningSum if "+runningSum);
                // Reset seen sums
                seenSums.clear();
                seenSums.add(0);
            }
            seenSums.add(runningSum);
            System.out.println(" seenSums  "+seenSums);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> messages = Arrays.asList(4, 3, -2, -1, 1);
        System.out.println(getMinInsertion(messages)); // Expected Output: 2
    }
}


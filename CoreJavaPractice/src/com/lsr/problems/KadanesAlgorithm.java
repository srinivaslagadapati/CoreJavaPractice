package com.lsr.problems;

//Problem Statement: Given an integer array nums, 
//find the contiguous subarray (containing at least one number)
//which has the largest sum and return its sum.
public class KadanesAlgorithm {

	public static void main(String[] args) {
		
		int nums[] = {3,1,4,5};
		
		findLargestSumOfArray(nums);
		
		System.out.println(maxSubArray(nums));

	}

	private static int findLargestSumOfArray(int[] nums) {
		
		int max = nums[0];
		int globalMax = nums[0];
		
		for(int i=1; i<nums.length; i++) {
			System.out.println(nums[i]);
			System.out.println(max);
			System.out.println(globalMax);

			max = Math.max(nums[i], max+nums[i]);
			globalMax = Math.max(globalMax, max);	
		}

		return globalMax;
		
		
	}
	
	public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int currentMax = nums[0];
        int globalMax = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            globalMax = Math.max(globalMax, currentMax);
        }
        
        return globalMax;
    }

}

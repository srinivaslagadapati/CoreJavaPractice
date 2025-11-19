package com.lsr.problems;

import java.util.Iterator;

//Problem Statement (Assumed): Given an array of positive integers and a positive integer S, find the length of the 
//smallest contiguous subarray whose sum is greater than or equal to S. If no such subarray exists, return 0.
public class MinSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {3,6,4,1,7,8};
		System.out.println(minSubArrayLen(18, nums)); ;

	}
	public static int minSubArrayLen(int S, int[] nums) {
		int minLength=Integer.MAX_VALUE;
		
		int left =0;
		int currentSum = 0;
		
		for(int right =0; right<nums.length;right++) {
			
			currentSum= currentSum+nums[right];
			System.out.println(currentSum);
			while(currentSum > S) {
				System.out.println("left "+left+ " right "+ right);

				System.out.println("right-left+1 "+ (right-left+1));

				minLength = Math.min(currentSum, right-left+1);
				currentSum -= nums[left];
				System.out.println("currentSum "+currentSum);
				System.out.println("minLength "+minLength);

				left++;
			}

			
		}
		
		
		
		return minLength == Integer.MAX_VALUE ? 0 : minLength;
		
	}

}

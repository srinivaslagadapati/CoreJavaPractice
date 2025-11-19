package Monotonic;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class nextGreaterElement {
	
	 public static int[] nextGreaterElementVal(int[] nums1, int[] nums2) {
		 
		 int[] nextGreaterElement = new int[nums1.length];
		 
		 Deque<Integer> stack = new ArrayDeque<Integer>();
		 Map<Integer,Integer> greaterMap = new HashMap<Integer, Integer>();
	//	 for (Entry<Integer,Integer> entry : greaterMap.entrySet()) {entry.getKey();}
		 
		 for(int num : nums2) {
			 System.out.println("num "+ num);
			// while(!stack.isEmpty() && num < stack.peek()) { // next smallest element
		     while(!stack.isEmpty() && num < stack.peek()) { // next largest element
				 System.out.println("stack.peek() "+ stack.peek());
				 greaterMap.put(stack.peek(),num);
				 stack.pop();
			 }
			 
			 stack.push(num);
			 System.out.println("stack "+ stack);
			 System.out.println("--- ");
		 }
		 System.out.println("greaterMap "+ greaterMap);
		 
		 for(int i=0; i<nums1.length;i++) {
			if ( greaterMap.get(nums1[i]) != null) {
				nextGreaterElement[i] = greaterMap.get(nums1[i]);
			}else {
				nextGreaterElement[i] =-1;
			}
		 }
		 
		 
		 return nextGreaterElement;
	 }

	public static void main(String[] args) {
		 // Example 1: nums1 = [4,1,2], nums2 = [1,3,4,2]
        int[] nums1_1 = {4, 1, 2};
        int[] nums2_1 = {1, 3, 4, 2};
        int[] result1 = nextGreaterElement.nextGreaterElementVal(nums1_1, nums2_1);
        System.out.println("Input: nums1=" + Arrays.toString(nums1_1) + ", nums2=" + Arrays.toString(nums2_1));
        System.out.println("Output: " + Arrays.toString(result1)); // Expected: [-1, 3, -1]

        // Example 2: nums1 = [2,4], nums2 = [1,2,3,4]
        int[] nums1_2 = {2, 4};
        int[] nums2_2 = {1, 2, 3, 4};
        int[] result2 = nextGreaterElement.nextGreaterElementVal(nums1_2, nums2_2);
        System.out.println("\nInput: nums1=" + Arrays.toString(nums1_2) + ", nums2=" + Arrays.toString(nums2_2));
        System.out.println("Output: " + Arrays.toString(result2)); // Expected: [3, -1]

	}

}

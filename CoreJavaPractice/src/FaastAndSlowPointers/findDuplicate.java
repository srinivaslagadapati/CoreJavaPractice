package FaastAndSlowPointers;

import java.util.HashSet;

class findDuplicate {
   
    public static int findDuplicateVal1(int[] nums) {
    	int duplicatVal =0;
    	int i=0;
    	int n= nums.length;
    	HashSet<Integer> addNums = new HashSet<Integer>();
    	
    	while(i<n) {
    		System.out.println(addNums);
    		if (addNums.contains(nums[i])) {return nums[i];}
    		else {
    		addNums.add(nums[i]);
    		}
    		System.out.println("---");
    		i++;
    	}
    	
    	return duplicatVal;
    }
    
    /**
     * Finds the duplicate number in an array using Floyd's Tortoise and Hare 
     * (Cycle Detection) algorithm.
     * * Constraints: The array contains n+1 numbers, all between 1 and n.
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param nums The integer array with exactly one duplicate.
     * @return The duplicate integer.
     */
    public static int findDuplicateVal(int[] nums) {
    	int tortise =0;
    	int hare =0;
    	
    	while (true) {
    		tortise = nums[tortise];  // move 1 step
    		hare= nums[nums[hare]];		// move 2 steps 
    		if (nums[tortise] == nums[hare]) {
    			System.out.println("circle found at "+nums[tortise]);
    			break;
    		}
    	}
    	
    	tortise =0;
    	System.out.println(tortise);
		System.out.println(hare);
		System.out.println("---");
    	while (tortise != hare) {
    		System.out.println("meeting point "+tortise);
    		tortise = nums[tortise];  
    		hare= nums[hare];	
    		
    	}
    	
    	
    	
    	return tortise;
    }
    

	public static void main(String[] args) {
		int[] nums = {7,3,4,5,1,8,6,9,2,2};
		System.out.print(findDuplicateVal(nums));
	}

}

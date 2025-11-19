package prefixsum;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarraySumK {

	public static void main(String[] args) {
		int[] nums = {1, 2, -1, 1, 1, 1, -1, 3};
		//int[] nums = {1, 1, 1};
		// int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
		 //  sumMap = {3=0, 7=1, 14=2, 16=3, 13=4, 14=5, 18=6, 20=7};
	        int k = 7;
	        System.out.println(practice(nums, k));  // Output: 6
	        System.out.println(largestSubarraySumK(nums, k));  // Output: 6

	}
	
	 public static int practice(int[] nums, int k) {
		 int max =0;
		 int sum =0;
		 Map<Integer,Integer> sumMap = new HashMap();
		 for (int i=0; i<nums.length;i++) {
			 System.out.println(" i is "+i +" sum is "+ sum);
			 sum += nums[i];
			 System.out.println(" sum after "+ sum);
// sumMap {1=0, 2=2, 3=3, 4=4, 5=5}
//	sumMap {1=0, 2=2, 3=1, 4=4, 5=5, 7=7}
			 
			 if( sum == k) {
				 max = i+1; 
			 }
			 if(sumMap.containsKey(sum-k) ) {
				 System.out.println(" old max "+max);
				 System.out.println(" sumMap "+sumMap);
				 max = Math.max(max, (i-sumMap.get(sum-k)));
				 System.out.println(" new max "+max);
			 }
			 
			 sumMap.put(sum,i);
			 System.out.println(" ---- ");
		 }
		
		 System.out.println(" max "+max);
		 return max;
	 }
	 
    public static int largestSubarraySumK(int[] nums, int k) {
    	int largestSubarraySumK =0;
    	int sum =0;
    	HashMap<Integer,Integer> sumMap = new HashMap<>();
    	for(int i=0; i< nums.length;i++) {
    		System.out.println("i is  "+i +" nums[i] "+nums[i]);
    		sum += nums[i];
    		System.out.println("sum+num  "+sum);
    		if (sum == k) {
    			largestSubarraySumK = i+1;
    			System.out.println(" largestSubarraySumK =="+largestSubarraySumK);
    		}
    		System.out.println("sum - 7  "+(sum-k));
    		if (sumMap.containsKey(sum - k)) {
    			System.out.println("i- sumMap.get(sum-k)  "+ (i-sumMap.get(sum-k)));
    			largestSubarraySumK = Math.max(largestSubarraySumK, i-sumMap.get(sum-k));
    			System.out.println(" Math.max largestSubarraySumK con "+largestSubarraySumK);
    			
    		}

    		if(!sumMap.containsKey(sum)){   			
    			sumMap.put(sum, i);
    			//System.out.println("sumMap  "+sumMap);

    		}
    		System.out.println(" sumMap "+sumMap);

    		System.out.println("---");
    		
    	}
    	
    	
		return largestSubarraySumK;

    }
}

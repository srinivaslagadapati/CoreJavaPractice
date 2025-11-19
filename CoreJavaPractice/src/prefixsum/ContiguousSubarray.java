package prefixsum;

import java.util.HashMap;

public class ContiguousSubarray {

	public static void main(String[] args) {
    	int[] nums = {0,1,1,0,0,0,1,1,1,1};

		findMaxLength(nums);
	}
	
	
	public static int findMaxLength(int[] nums) {
		int sum =0;
		int max =0;
		HashMap <Integer,Integer> sumMap = new HashMap<>();
		sumMap.put(0, -1);
		for(int i=0;i<nums.length;i++) {
			System.out.println(" i is "+i +" val "+nums[i]);
			System.out.println(" sumMap  "+sumMap);
			sum += (nums[i] == 0) ? -1 :1;
			System.out.println(" sum "+sum );
			
			if(sumMap.containsKey(sum) ) {
				System.out.println(" sumMap has sum "+sum );
				System.out.println(" max "+max);
				System.out.println(i+" - "+sumMap.get(sum));
				max= Math.max(max, i-sumMap.get(sum));
				System.out.println(" max is "+max);

			}else {
				sumMap.put(sum, i);
			}
			System.out.println(" sumMap  "+sumMap);
			System.out.println(" ----- ");

		}
		
		System.out.println("max "+max);

		return max;
		
		
	}

}

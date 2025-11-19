package twopointer;

import java.util.*;

public class ThreeSum {
	
	
	public static void main (String[] arge) {
		
		//int[] nums = {-1,0,1,2,-1,-4};
		int[] nums = {0,1,1};
		//threeSum(nums);
		int[] numbers= {2,7,11,15};
		int target =9;
		twoSum(numbers,target);
	}

	private static List<List<Integer>> threeSum(int[] nums) {
		
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList();
		
		int n = nums.length;
		System.out.println(Arrays.toString(nums));
		
		for (int i=0 ;i<n-2;i++) {
			System.out.println(i +" nums[i]  "+nums[i]);
			
			if(i>0 && nums[i]== nums[i-1]) {
				System.out.println(" nums[i-1]  "+nums[i-1]);
				System.out.println(" continue  ");
				System.out.println("-----");
				continue;
			}
			int left = i+1;
			int right = n-1;
			System.out.println(left  + " left  "+nums[left]);
			System.out.println(right+ " right  "+nums[right]);
			int target = - nums[i];
			while (left < right) {
				int twosum = nums[left]+nums[right];
				System.out.println("target "+target);
				System.out.println("twosum "+twosum);
				
				if (target == twosum) {
					result.add(Arrays.asList(nums[i],nums[left],nums[right]));
					while(left<right && nums[left] == nums[left+1]) {
						left++;
					}
					while(left<right && nums[right] == nums[right-1]) {
						right--;
					}
					left++;
					right--;
				}else if (target > twosum) {
					left++;
				}else if (target < twosum) {
					right--;
				}
				System.out.println("-----");
			}
		}
		
		System.out.println(result);
		return result;
	}
	
	public static int[] twoSum(int[] numbers, int target) {
		int n= numbers.length;
		int[] result = new int[2];
		
		int left =0;
		int right = n-1;
		System.out.println(Arrays.toString(numbers));
		while(left<right) {
			int sum = numbers[left] + numbers[right];
			if(sum == target) {
				result[0]=left+1;
				result[1]=right+1;
				System.out.println(Arrays.toString(result));

				return new int[] {left+1,right+1};
			}else if(sum < target) {
				left++;
			}else if(sum > target) {
				right--;
			}
			
		}
		System.out.println(Arrays.toString(result));
		
		return result;
        
    }
	

}

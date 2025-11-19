package slidingwindow;

import java.util.HashSet;

public class SlidingWindow {
	
	
	private static double findMaxAvg(int[] nums,int k){
		
		int sum=0;
		int n= nums.length;
		for (int i=0;i<k;i++) { // loop k times
			sum+= nums[i];
		}
		System.out.println(sum);
		int maxSum=sum;
		
		for (int i=k;i<n;i++) { // loop n-k times
			System.out.println(" sum "+nums[k]);
			sum-= nums[i-k];
			System.out.println(" sum- "+sum);
			sum += nums[i];
			System.out.println(" sum+ "+sum);
			maxSum= Math.max(maxSum, sum)	;
					System.out.println(" --- ");
		}
		System.out.println(maxSum);
		return (double) maxSum/k;
	}
	
	private static int lengthOfLongestSubstring(String s) {
		int maxLength =0;
		int n = s.length();
		int left =0;
		HashSet<Character> chars = new HashSet<Character>();
		//System.out.println(
		for(int right =0; right<n; right ++) {
			System.out.println("LS");
			
			System.out.println(left);
			System.out.println(right);
			while(chars.contains(s.charAt(right))) {
				System.out.println("char -- " +s.charAt(left));
				chars.remove(s.charAt(left));
				System.out.println("chars --"+ chars);
				left++;
			}
			chars.add(s.charAt(right));
			maxLength= Math.max(maxLength, right-left+1);
			System.out.println("chars ++"+chars);
			
			System.out.println(" maxLength " +maxLength);
			System.out.println("LE");
			System.out.println("----");
			
		}
		
		
		
		return maxLength;
	}

	public static void main(String[] args) {
		int[] nums = {1,12,-5,-6,50,3}; int k= 4;
		//System.out.println(findMaxAvg(nums,k));
		String s = "pwwkew";
		//String s = "abcab";
		System.out.println(lengthOfLongestSubstring(s));

	}

}

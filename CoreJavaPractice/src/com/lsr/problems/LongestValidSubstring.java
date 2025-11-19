package com.lsr.problems;

public class LongestValidSubstring {
	
			public static void main(String[] args) {
				
				 System.out.println(longestValidSubstring("abcd")); // Output: 4 System.out.println(longestValidSubstring("fghbbadcba")); // Output: 5 }}
			}
			public static int longestValidSubstring(String s) { 
				int maxLength = 0; int start = 0; 
				for (int end = 1; end < s.length(); end++) {
					if (s.charAt(start) < s.charAt(end)) 
					{ 
						maxLength = Math.max(maxLength, end - start + 1); }
					else {
						start = end; // Reset start to the current end index } }
						return maxLength; 
					}
			}
				return start;
			}
}
package com.lsr.problems;


//Problem Statement: Given a binary string (a string of zeros and ones),
//find the length of the longest contiguous sequence of ones.
public class LongestOnesSequence {

	public static void main(String[] args) {
		String s= "0111000001010101000011";
		
		System.out.println(findLongestSequence(s));

	}
	
	    public static int findLongestSequence(String s) {
	    	int longestSequence=0;
	    	
	    	char[] sInt = s.toCharArray();
	    	int oneCount =0;
	    	for (char c : sInt) {
	    		System.out.println(c);
	    		
	    		if(c == '0') {
	    			longestSequence = Math.max(longestSequence, oneCount);
	    			System.out.println("longestSequence max "+longestSequence);

	    			oneCount =0;
	    			System.out.println("oneCount reset "+oneCount);
	    		}else {
	    			oneCount++;
	    			System.out.println("oneCount++ "+oneCount);
	    		}
	    			
	    	}
	    	
			return longestSequence;
	    }


}

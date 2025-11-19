package com.lsr.problems;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {


		String s1 = "test";
		String s2 = "estt";
		
		System.out.println(isAnagram(s1,s2));
		
		System.out.println(isAnagram1(s1,s2));
		
		
	}
	
	private static boolean isAnagram(String s1, String s2) {
		
		s1= s1.replace("\\s", "").toLowerCase();
		s2= s2.replace("\\s", "").toLowerCase();
		if (s1.length() != s2.length()) return false;
		char[] a1= s1.toCharArray();
		char[] a2= s2.toCharArray();
		Arrays.sort(a1);
		Arrays.sort(a2);
		
		return Arrays.equals(a1, a2);
		
	}
	
	private static boolean isAnagram1(String s1, String s2) {
		
		s1= s1.replace("\\s", "").toLowerCase();
		s2= s2.replace("\\s", "").toLowerCase();
		
		if (s1.length() != s2.length()) return false;
		int[] counts = new int[26];
		
		for(int i=0;i<s1.length();i++) {
			
			char c1= s1.charAt(i);
			char c2= s2.charAt(i);
			
			System.out.println("step "+i );
			System.out.println("  Added '" + c1 + "' → counts[" + (c1-'a') + "]++");
            System.out.println("  Removed '" + c2 + "' → counts[" + (c2-'a') + "]--");
			counts[c1-'a']++;

			counts[c2-'a']--;

		}
		
		for(int count: counts) {
			System.out.println("count "+count );
			if (count !=0 ) return false;
		}
		
		
		return true;
		
	}


}

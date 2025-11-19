package com.lsr.problems;
import java.util.HashMap;
import java.util.Map;

public class getLongestSubstring {

    public static int getLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        int maxLength = 0;
        int start = 0; // start index of current substring window
        Map<Character, Integer> indexMap = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            System.out.println("Inspecting char '" + c + "' at index " + end);
            System.out.println("at start " + start);

            if (indexMap.containsKey(c) && indexMap.get(c) >= start) {
                System.out.println("Found repeating char '" + c + "' previously at index " + indexMap.get(c));
                start = indexMap.get(c) + 1;
                System.out.println("Move start to " + start);
            }

            indexMap.put(c, end);
            int currentLength = end - start + 1;
            maxLength = Math.max(maxLength, currentLength);

            System.out.println("Current substring window: [" + start + ", " + end + "] (length " + currentLength + ")");
            System.out.println("getLongestSubstring Max length so far: " + maxLength);
            System.out.println("-------------------------------");
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "appleoffn";
        int result = 0;
        int result1 = 0;
		try {
			result = getLonestString(s);
			result1=getLongestSubstring(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    private static int getLonestString(String s) {
    	

    	Map<Character,Integer> charMap =new HashMap<Character, Integer>();
    	int start =0;
    	int maxLength =0;
    	for (int i=0 ; i<s.length() ; i++) {
    		
    		System.out.println(i +" ----   current char " +s.charAt(i));
    		
    		System.out.println(" found " +charMap.containsKey(s.charAt(i)));  

    		if(charMap.containsKey(s.charAt(i))) {

    			
        		System.out.println(" maxLength " +maxLength);  
        		start = i;
        		System.out.println("reset start to " +start);    		    		

    		}
    		charMap.put(s.charAt(i),(i-start)+1);
			maxLength = Math.max(maxLength, (i-start)+1);
			System.out.println(" charMap " +charMap);   
    		
    	}
		System.out.println("getLonestString  maxLength final" +maxLength);   

    	
    	return maxLength; 
    	
    }
}

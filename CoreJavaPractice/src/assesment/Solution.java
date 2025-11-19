package assesment;

import java.util.*;


public class Solution {
	    public static String getMinimumString(String s_id) {
	    	System.out.println("s_id "+s_id);
	        int n = s_id.length();
	        StringBuilder sb = new StringBuilder(s_id);
	        System.out.println("org sb "+sb);
	        // Step 1: Identify the first position where a digit is greater than the next one
	        int removeIndex = -1;
	        for (int i = 0; i < n - 1; i++) {
	            if (sb.charAt(i) > sb.charAt(i + 1)) {
	                removeIndex = i;
	                System.out.println("removeIndex "+removeIndex);
	                break;
	            }
	        }

	        // If no decreasing pair is found, remove the last character
	        if (removeIndex == -1) {
	            removeIndex = n - 1;
	            System.out.println("removeIndex "+removeIndex);
	        }

	        // Step 2: Remove the identified character
	        char removedChar = sb.charAt(removeIndex);
	        sb.deleteCharAt(removeIndex);
	        System.out.println("sb "+sb);
	        // Step 3: Increment the removed character (capped at '9')
	        char newChar = (char) Math.min(removedChar + 1, '9');
	        System.out.println("newChar  "+newChar);
	        // Step 4: Insert newChar at the correct position to maintain sorted order
	        int insertIndex = 0;
	        System.out.println("insertIndex  "+insertIndex);
	        System.out.println("sb.charAt(insertIndex) <= newchar  "+sb.charAt(insertIndex));
	        while (insertIndex < sb.length() && sb.charAt(insertIndex) <= newChar) {
	            insertIndex++;
	        }

	        sb.insert(insertIndex, newChar);
	        System.out.println("sb final "+sb);
	        return sb.toString();
	    }

	    public static void main(String[] args) {
	        System.out.println(getMinimumString("34892")); // Expected Output: "24599"
	    }
	}
